package it.xquickglare.quicklib.utils;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Message {

    @Getter
    @Setter
    private String message;

    public Message(String message) {
        this.message = message;
    }

    public void send(Player player) {
        player.sendMessage(message);
    }

    public Message broadcast() {
        Bukkit.getServer().broadcastMessage(message);
        return this;
    }

    public Message broadcastWithPermission(String permission) {
        Bukkit.broadcast(message, permission);
        return this;
    }

    public Message addPlaceholder(String placeholder, String value) {
        message = message.replaceAll("%" + placeholder, value);
        return this;
    }

    public Message format(char colorCode) {
        message = ChatColor.translateAlternateColorCodes(colorCode, message);
        return this;
    }

    public static String format(String message, char colorCode) {
        return ChatColor.translateAlternateColorCodes(colorCode, message);
    }
}
