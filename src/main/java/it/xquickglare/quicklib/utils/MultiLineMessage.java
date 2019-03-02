package it.xquickglare.quicklib.utils;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.stream.Collectors;

public class MultiLineMessage {

    @Getter
    @Setter
    private List<String> multiLineMessage;

    public MultiLineMessage(List<String> multiLineMessage) {
        this.multiLineMessage = multiLineMessage;
    }

    public MultiLineMessage send(Player player) {
        multiLineMessage.forEach(player::sendMessage);
        return this;
    }

    public MultiLineMessage broadcast() {
        multiLineMessage.forEach(Bukkit::broadcastMessage);
        return this;
    }

    public MultiLineMessage broadcastWithPermission(String permission) {
        multiLineMessage.forEach(line -> Bukkit.broadcast(line, permission));
        return this;
    }

    public MultiLineMessage addPlaceholder(String placeholder, String value) {
        for (int i = 0; i < multiLineMessage.size(); i++) {
            String s = multiLineMessage.get(i).replaceAll("%" + placeholder, value);
            multiLineMessage.set(i, s);
        }

        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        multiLineMessage.forEach(builder::append);
        
        return builder.toString();
    }

    public MultiLineMessage format(char colorCode) {
        multiLineMessage.stream().map(
                msg -> ChatColor.translateAlternateColorCodes(colorCode, msg)
        ).collect(Collectors.toList());
        return this;
    }

    public static List<String> format(List<String> multiLineMessage, char colorCode) {
        return multiLineMessage.stream().map(
                msg -> ChatColor.translateAlternateColorCodes(colorCode, msg)
        ).collect(Collectors.toList());
    }
}