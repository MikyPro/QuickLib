package it.xquickglare.quicklib.utils;

import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Listener;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Hologram implements Listener {

    private Location location;
    private Map<String, ArmorStand> armorstands;

    public Hologram(Location location) {
        this.location = location;
        armorstands = new HashMap<>();

        armorstands.put("Test", null);
        armorstands.put("Another test", null);
    }

    public Hologram create() {
        double yLoc = 0;
        for (String text : armorstands.keySet()) {
            ArmorStand as = (ArmorStand) location.getWorld().spawnEntity(location.add(0, yLoc, 0), EntityType.ARMOR_STAND);

            as.setCustomName(text);
            as.setGravity(false);
            as.setInvulnerable(true);
            as.setCanPickupItems(false);
            as.setCustomNameVisible(true);
            as.setVisible(false);

            armorstands.put(text, as);
            yLoc += 0.2;
        }
        return this;
    }

    public Hologram delete() {
        armorstands.forEach((text, entity) -> {
            if(entity != null)
                entity.remove();
        });
        return this;
    }

    public Hologram addText(String text) {
        armorstands.put(text, null);
        return this;
    }

    public Hologram setLocation(Location location) {
        this.location = location;
        return this;
    }
}
