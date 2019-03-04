package it.xquickglare.quicklib.nms;

import it.xquickglare.quicklib.nms.actionbar.v1_8.ActionBar_R1;
import it.xquickglare.quicklib.nms.actionbar.v1_8.ActionBar_R2;
import it.xquickglare.quicklib.nms.actionbar.v1_8.ActionBar_R3;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.lang.reflect.Method;

public class ActionBar {

    private final String message;


    public ActionBar(String message) {
        this.message = message;
    }

    public boolean send(Player player) {

        String version = NMSUtils.getServerVersion();

        if (version.startsWith("v1_7")) return false; //new it.xquickglare.quicklib.nms.actionbar.v1_7.FakeActionBar_R1(player, message);

        if (NMSUtils.isVersionBigger(1.10f)) {
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
            return true;
        }

        if ("v1_8_R1".equals(version)) {
            new ActionBar_R1(player, message);
        } else if ("v1_8_R2".equals(version)) {
            new ActionBar_R2(player, message);
        } else if ("v1_8_R3".equals(version)) {
            new ActionBar_R3(player, message);
        } else if ("v1_9_R1".equals(version)) {
            new it.xquickglare.quicklib.nms.actionbar.v1_9.ActionBar_R1(player, message);
        } else if ("v1_9_R2".equals(version)) {
            new it.xquickglare.quicklib.nms.actionbar.v1_9.ActionBar_R2(player, message);
        }
        return true;
    }

    public ActionBar format(char colorCode) {
        ChatColor.translateAlternateColorCodes(colorCode, message);
        return this;
    }
}
