package it.xquickglare.quicklib.nms.title.v1_8;

import net.minecraft.server.v1_8_R1.*;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Title_R1 {

    public Title_R1(String title, String subtitle, int fadeInTime, int fadeOutTime, int showTime, Player player) {
        Packet[] packets = new Packet[3];
        packets[0] = new PacketPlayOutTitle(EnumTitleAction.TITLE, ChatSerializer.a("{\"text\": \"" + title + "}"));
        packets[1] = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, ChatSerializer.a("{\"text\": \"" + subtitle + "}"));
        packets[2] = new PacketPlayOutTitle(fadeInTime, showTime, fadeOutTime);

        for (Packet packet : packets)
            ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
    }
}
