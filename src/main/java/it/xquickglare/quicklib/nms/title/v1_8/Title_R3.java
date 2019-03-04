package it.xquickglare.quicklib.nms.title.v1_8;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Title_R3 {

    public Title_R3(String title, String subtitle, int fadeInTime, int fadeOutTime, int showTime, Player player) {
        Packet[] packets = new Packet[3];
        packets[0] = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + title + "}"));
        packets[1] = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + subtitle + "}"));
        packets[2] = new PacketPlayOutTitle(fadeInTime, showTime, fadeOutTime);

        for (Packet packet : packets)
            ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
    }
}
