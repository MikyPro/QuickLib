package it.xquickglare.quicklib.nms;

import it.xquickglare.quicklib.nms.title.v1_8.Title_R1;
import it.xquickglare.quicklib.nms.title.v1_8.Title_R2;
import it.xquickglare.quicklib.nms.title.v1_8.Title_R3;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.lang.reflect.Constructor;

public class Title {

    private String title;
    private String subtitle;
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

        if (version.startsWith("v1_7")) return false;

        if (NMSUtils.isVersionBigger(1.12f)) {
            player.sendTitle(title, subtitle, fadeInTime, showTime, fadeOutTime);
            return true;
        }

        if ("v1_8_R1".equals(version)) {
            new Title_R1(title, subtitle, fadeInTime, fadeOutTime, showTime, player);
        } else if ("v1_8_R2".equals(version)) {
            new Title_R2(title, subtitle, fadeInTime, fadeOutTime, showTime, player);
        } else if ("v1_8_R3".equals(version)) {
            new Title_R3(title, subtitle, fadeInTime, fadeOutTime, showTime, player);
        } else if ("v1_9_R1".equals(version)) {
            new it.xquickglare.quicklib.nms.title.v1_9.Title_R1(title, subtitle, fadeInTime, fadeOutTime, showTime, player);
        } else if ("v1_9_R2".equals(version)) {
            new it.xquickglare.quicklib.nms.title.v1_9.Title_R2(title, subtitle, fadeInTime, fadeOutTime, showTime, player);
        } else if ("v1_10_R1".equals(version)) {
            new it.xquickglare.quicklib.nms.title.v1_10.Title_R1(title, subtitle, fadeInTime, fadeOutTime, showTime, player);
        } else if ("v1_11_R1".equals(version)) {
            new it.xquickglare.quicklib.nms.title.v1_11.Title_R1(title, subtitle, fadeInTime, fadeOutTime, showTime, player);
        }
        return true;
    }

    public Title format(char colorCode) {
        title = ChatColor.translateAlternateColorCodes(colorCode, title);
        subtitle = ChatColor.translateAlternateColorCodes(colorCode, subtitle);
        return this;
    }
}
