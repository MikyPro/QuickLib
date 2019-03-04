package it.xquickglare.quicklib.nms.actionbar.v1_9;

import net.minecraft.server.v1_9_R1.ChatComponentText;
import net.minecraft.server.v1_9_R1.PacketPlayOutChat;
import org.bukkit.craftbukkit.v1_9_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ActionBar_R1 {

    public ActionBar_R1(Player player, String message) {
        PacketPlayOutChat packetPlayOutChat = new PacketPlayOutChat(new ChatComponentText(message), (byte)2);
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(packetPlayOutChat);
    }
}
