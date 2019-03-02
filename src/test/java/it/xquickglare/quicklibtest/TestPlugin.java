package it.xquickglare.quicklibtest;

import it.xquickglare.quicklib.QuickLib;
import it.xquickglare.quicklib.configuration.JSONConfiguration;
import it.xquickglare.quicklib.configuration.YAMLConfiguration;
import it.xquickglare.quicklib.holograms.Hologram;
import it.xquickglare.quicklib.nms.ActionBar;
import it.xquickglare.quicklib.nms.Title;
import it.xquickglare.quicklib.utils.Message;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin extends JavaPlugin implements Listener {

    private QuickLib quickLib;

    @Override
    public void onEnable() {
        quickLib = new QuickLib(this);

        quickLib.register(new TestCommand());

        getServer().getPluginManager().registerEvents(this, this);

        testYAMLConfig();
        testJSONConfig();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Title title = new Title("§cHello", "&cWorld", 5, 5, 20);
        title.send(e.getPlayer());

        ActionBar actionBar = new ActionBar("Hello World!");
        actionBar.send(e.getPlayer());

        Message message = new Message("Hello World");
        message.send(e.getPlayer());

        Hologram hd = new Hologram(e.getPlayer().getLocation().add(0, 3, 0));
        hd.addLine("Hi, i'm an Hologram").create();
    }
    
    private void testYAMLConfig() {
        System.out.println("Started testing of YAMLConfiguration...");
        YAMLConfiguration config = new YAMLConfiguration("config", quickLib);
        
        System.out.println("String: " + config.getString("string"));
        System.out.println("List of Strings: " + config.getStringList("stringList"));
        
        System.out.println("Boolean: " + config.getBoolean("boolean"));
        
        System.out.println("Integer: " + config.getInteger("integer"));
        System.out.println("List of Integers: " + config.getIntegerList("integerList"));
        
        System.out.println("Double: " + config.getDouble("double"));
        System.out.println("List of Doubles: " + config.getDoubleList("doubleList"));
        
        System.out.println("Float: " + config.getFloat("float"));
        System.out.println("List of Floats: " + config.getFloatList("floatList"));
        
        config.set("newString", "A new string");
        config.saveConfiguration();
        
        System.out.println("New String: " + config.getString("newString"));
        
        System.out.println("Finished testing of YAMLConfiguration");
    }
    
    private void testJSONConfig() {
        System.out.println("Started testing of JSONConfiguration...");
        JSONConfiguration config = new JSONConfiguration("config", quickLib);

        System.out.println("String: " + config.getString("string"));
        System.out.println("List of Strings: " + config.getStringList("stringList"));

        System.out.println("Boolean: " + config.getBoolean("boolean"));

        System.out.println("Integer: " + config.getInteger("integer"));
        System.out.println("List of Integers: " + config.getIntegerList("integerList"));

        System.out.println("Double: " + config.getDouble("double"));
        System.out.println("List of Doubles: " + config.getDoubleList("doubleList"));

        System.out.println("Float: " + config.getFloat("float"));
        System.out.println("List of Floats: " + config.getFloatList("floatList"));

        config.set("newString", "A new string");
        config.saveConfiguration();

        System.out.println("New String: " + config.getString("newString"));
        
        System.out.println("Finished testing of JSONConfiguration");
    }
}
