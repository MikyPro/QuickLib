package it.xquickglare.quicklib.nms;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.lang.reflect.Constructor;

public class Title {

    private final NMSUtils nmsUtils;

    @Getter @Setter private String title;
    @Getter @Setter private String subtitle;
    @Getter @Setter private int fadeInTime;
    @Getter @Setter private int fadeOutTime;
    @Getter @Setter private int showTime;
    
    public Title(String title, String subtitle, int fadeInTime, int fadeOutTime, int showTime){
        nmsUtils = new NMSUtils();
        
        this.title = ChatColor.translateAlternateColorCodes('&', title);
        this.subtitle = ChatColor.translateAlternateColorCodes('&', subtitle);
        this.fadeInTime = fadeInTime;
        this.fadeOutTime = fadeOutTime;
        this.showTime = showTime;
    }

    public boolean sendTitle(Player player) {
        String version = nmsUtils.getServerVersion();

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
