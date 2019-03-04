package it.xquickglare.quicklib.nms.title.v1_8;

import net.minecraft.server.v1_8_R2.IChatBaseComponent;
import net.minecraft.server.v1_8_R2.Packet;
import net.minecraft.server.v1_8_R2.PacketPlayOutTitle;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Title_R2 {

    public Title_R2(String title, String subtitle, int fadeInTime, int fadeOutTime, int showTime, Player player) {
        Packet[] packets = new Packet[3];
        packets[0] = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + title + "}"));
        packets[1] = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + subtitle + "}"));
        packets[2] = new PacketPlayOutTitle(fadeInTime, showTime, fadeOutTime);

        for (Packet packet : packets)
            ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
    }
}
