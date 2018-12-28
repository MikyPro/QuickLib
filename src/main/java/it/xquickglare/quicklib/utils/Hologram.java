package it.xquickglare.quicklib.utils;

import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;

public class Hologram implements Listener {

    @Getter
    private String text;
    @Getter
    private Location location;
    @Getter
    private ArmorStand armorStand;

    public Hologram create() {
        ArmorStand as = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);

        as.setGravity(false);
        as.setCanPickupItems(false);
        as.setCustomName(text);
        as.setCustomNameVisible(true);
        as.setVisible(false);

        armorStand = as;
        return this;
    }

    public Hologram delete() {
        armorStand.remove();
        return this;
    }

    @EventHandler
    public void manipulate(PlayerArmorStandManipulateEvent e) {
        if (!e.getRightClicked().isVisible()) {
            e.setCancelled(true);
        }
    }

    public Hologram setText(String text) {
        this.text = text;
        return this;
    }

    public Hologram setLocation(Location location) {
        this.location = location;
        return this;
    }
}
