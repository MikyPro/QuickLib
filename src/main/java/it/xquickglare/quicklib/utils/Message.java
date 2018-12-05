package it.xquickglare.quicklib.utils;

import org.bukkit.entity.Player;

import java.util.List;

public class Message {

    public void sendMultiLineMessage(Player player, List<String> lines){
        lines.forEach(player::sendMessage);
    }
}
