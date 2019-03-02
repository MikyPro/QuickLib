package it.xquickglare.quicklib.holograms;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;

public class HologramLine {

    private String text;
    private ArmorStand as;

    public HologramLine(String text) {
        this.text = text;
    }

    public void spawn(Location loc) {
        if(as != null)
            despawn();

        as = (ArmorStand) loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
        as.setCustomName(text);
        as.setGravity(false);
        as.setInvulnerable(true);
        as.setCanPickupItems(false);
        as.setCustomNameVisible(true);
        as.setVisible(false);
    }

    public void despawn() {
        if(as == null)
            return;

        as.remove();
        as = null;
    }

    public void setText(String text) {
        this.text = text;
    }

}
