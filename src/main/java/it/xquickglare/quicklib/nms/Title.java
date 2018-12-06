package it.xquickglare.quicklib.nms;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.lang.reflect.Constructor;

public class Title {

    private final String title;
    private final String subtitle;
    private final int fadeInTime;
    private final int fadeOutTime;
    private final int showTime;

    public Title(String title, String subtitle, int fadeInTime, int fadeOutTime, int showTime){
        this.title = title;
        this.subtitle = subtitle;
        this.fadeInTime = fadeInTime;
        this.fadeOutTime = fadeOutTime;
        this.showTime = showTime;
    }

    public boolean send(Player player) {
        String version = NMSUtils.getServerVersion();

        if (NMSUtils.isVersionBigger(1.12f)) {
            player.sendTitle(title, subtitle, fadeInTime, showTime, fadeOutTime);
            return true;
        } else if (version.startsWith("v1_7")) {
            return false;
        } else {
            try {
                Object chatTitle = NMSUtils.getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\": \"" + title + "\"}");
                Constructor<?> titleConstructor = NMSUtils.getNMSClass("PacketPlayOutTitle").getConstructor(NMSUtils.getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], NMSUtils.getNMSClass("IChatBaseComponent"), int.class, int.class, int.class);
                Object titlePacket = titleConstructor.newInstance(NMSUtils.getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("TITLE").get(null), chatTitle, fadeInTime, showTime, fadeOutTime);


                Object chatSubtitle = NMSUtils.getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\": \"" + title + "\"}");
                Constructor<?> subtitleConstructor = NMSUtils.getNMSClass("PacketPlayOutTitle").getConstructor(NMSUtils.getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], NMSUtils.getNMSClass("IChatBaseComponent"), int.class, int.class, int.class);
                Object subtitlePacket = subtitleConstructor.newInstance(NMSUtils.getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("SUBTITLE").get(null), chatTitle, fadeInTime, showTime, fadeOutTime);

                NMSUtils.sendPacket(player, titlePacket);
                NMSUtils.sendPacket(player, subtitlePacket);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return true;
    }

    public Title format(char colorCode) {
        ChatColor.translateAlternateColorCodes(colorCode, title);
        ChatColor.translateAlternateColorCodes(colorCode, subtitle);
        return this;
    }
}
