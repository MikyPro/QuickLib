package it.xquickglare.quicklib;

import it.xquickglare.quicklib.command.Command;
import it.xquickglare.quicklib.command.CommandHandler;
import it.xquickglare.quicklib.utils.Hologram;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class QuickLib {
    
    @Getter private final JavaPlugin plugin;
    
    public QuickLib(JavaPlugin plugin){
        this.plugin = plugin;
    }

    /**
     * Method called once the plugin is loaded and enabled
     */
    public void enable() {
        plugin.getServer().getPluginManager().registerEvents(new Hologram(), plugin);
    }

    /**
     * Method called once the plugin is closed/disabled
     */
    public void disable() {
        
    }

    /**
     * Registers a command
     * @param command Command to register. Can be either a {@link Command} or a {@link it.xquickglare.quicklib.command.SubCommand}
     */
    public void register(Command command) {
        plugin.getCommand(command.getName()).setExecutor(new CommandHandler(command));
    }
}
