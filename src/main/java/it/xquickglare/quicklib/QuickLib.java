package it.xquickglare.quicklib;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class QuickLib {
    
    @Getter private final JavaPlugin plugin;
    
    public QuickLib(JavaPlugin plugin){
        this.plugin = plugin;
    }
    
    public void enable() {
        
    }
    
    public void disable() {
        
    }
    
}
