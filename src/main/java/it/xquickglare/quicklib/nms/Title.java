package it.xquickglare.quicklib.nms;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.lang.reflect.Constructor;

public class Title {

    private final NMSUtils nmsUtils;

    public Title(){
        nmsUtils = new NMSUtils();
    }

    public boolean sendTitle(Player player, String title, String subtitle, int fadeInTime, int showTime, int fadeOutTime) {
        String version = nmsUtils.getServerVersion();

        title = ChatColor.translateAlternateColorCodes('&', title);
        subtitle = ChatColor.translateAlternateColorCodes('&', subtitle);

       if(version.startsWith("v1_12")){
           player.sendTitle(title, subtitle, fadeInTime, showTime, fadeOutTime);
           return true;
       } else if(version.startsWith("v1_7")){
           return false;
       } else {
           try {
               Object chatTitle = nmsUtils.getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\": \"" + title + "\"}");
               Constructor<?> titleConstructor = nmsUtils.getNMSClass("PacketPlayOutTitle").getConstructor(nmsUtils.getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], nmsUtils.getNMSClass("IChatBaseComponent"), int.class, int.class, int.class);
               Object titlePacket = titleConstructor.newInstance(nmsUtils.getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("TITLE").get(null), chatTitle, fadeInTime, showTime, fadeOutTime);


               Object chatSubtitle = nmsUtils.getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\": \"" + title + "\"}");
               Constructor<?> subtitleConstructor = nmsUtils.getNMSClass("PacketPlayOutTitle").getConstructor(nmsUtils.getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], nmsUtils.getNMSClass("IChatBaseComponent"), int.class, int.class, int.class);
               Object subtitlePacket = subtitleConstructor.newInstance(nmsUtils.getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("SUBTITLE").get(null), chatTitle, fadeInTime, showTime, fadeOutTime);

               nmsUtils.sendPacket(player, titlePacket);
               nmsUtils.sendPacket(player, subtitlePacket);
           } catch (Exception ex) {
               ex.printStackTrace();
           }
       }
       return true;
    }
}
