package it.xquickglare.quicklib.nms.actionbar.v1_7;

import it.xquickglare.quicklib.QuickLib;
import net.minecraft.server.v1_7_R1.*;
import org.bukkit.craftbukkit.v1_7_R1.inventory.CraftItemStack;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class FakeActionBar_R1 {

    public static Plugin plugin;

    public FakeActionBar_R1(Player player, String message) {
        ItemStack itemStack = ((CraftPlayer)player).getHandle().inventory.getItem(player.getInventory().getHeldItemSlot()+36);
        org.bukkit.inventory.ItemStack fakeItemStack = CraftItemStack.asBukkitCopy(itemStack.cloneItemStack());
        ItemMeta itemMeta = fakeItemStack.getItemMeta();
        itemMeta.setDisplayName(message);
        fakeItemStack.setItemMeta(itemMeta);
        PacketPlayOutSetSlot packetPlayOutHeldItemSlot = new PacketPlayOutSetSlot(0, player.getInventory().getHeldItemSlot()+36, CraftItemStack.asNMSCopy(fakeItemStack));
        PacketPlayOutSetSlot afterPacketPlayOutHeldItemSlot = new PacketPlayOutSetSlot(0, player.getInventory().getHeldItemSlot()+36, itemStack);
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(packetPlayOutHeldItemSlot);
        new BukkitRunnable() {
            @Override
            public void run() {
                ((CraftPlayer)player).getHandle().playerConnection.sendPacket(afterPacketPlayOutHeldItemSlot);
            }
        }.runTaskLaterAsynchronously(plugin, 10L);
    }
}
