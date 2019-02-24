package it.xquickglare.quicklib.utils;

import it.xquickglare.quicklib.configuration.Configuration;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

@AllArgsConstructor @Getter
public class ItemBuilder {

    private String name;
    private Material material;
    private List<String> lore;
    private int amount;

    public ItemBuilder(Configuration config, String path) {
        this(
                config.getMessage(path + ".name").format('&').getMessage(),
                Material.valueOf(config.getString(path + ".material")),
                config.getMultiLineMessage(path + ".lore").format('&').getMultiLineMessage(),
                config.getInteger(path + ".amount")
        );
    }

    public ItemStack toItemStack() {
        ItemStack item = new ItemStack(material, amount);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(name);
        meta.setLore(lore);

        item.setItemMeta(meta);
        return item;
    }
}
