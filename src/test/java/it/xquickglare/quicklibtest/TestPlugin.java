package it.xquickglare.quicklibtest;

import it.xquickglare.quicklib.QuickLib;
import it.xquickglare.quicklib.configuration.JSONConfiguration;
import it.xquickglare.quicklib.configuration.YAMLConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin extends JavaPlugin {

    private QuickLib quickLib;
    
    @Override
    public void onEnable() {
        quickLib = new QuickLib(this);
        
        testYAMLConfig();
        testJSONConfig();
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
