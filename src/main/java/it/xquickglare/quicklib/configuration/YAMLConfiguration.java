package it.xquickglare.quicklib.configuration;

import it.xquickglare.quicklib.QuickLib;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class YAMLConfiguration extends Configuration{
    
    private File file;
    private FileConfiguration configuration;
    
    public YAMLConfiguration(String name, QuickLib lib) {
        file = new File(lib.getPlugin().getDataFolder(), name + ".yml");

        if(!file.exists())
            lib.getPlugin().saveResource(name + ".yml", false);
        
        reload();
    }
    
    @Override
    public boolean saveConfiguration() {
        try {
            configuration.save(file);
        } catch (IOException e) {
            //TODO Use the log system.
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

    @Override
    public void reload() {
        configuration = YamlConfiguration.loadConfiguration(file);
    }

    @Override
    public void set(String path, Object value) {
        configuration.set(path, value);
    }

    @Override
    public String getString(String path) {
        return configuration.getString(path);
    }

    @Override
    public List<String> getStringList(String path) {
        return configuration.getStringList(path);
    }

    @Override
    public boolean getBoolean(String path) {
        return configuration.getBoolean(path);
    }

    @Override
    public Integer getInteger(String path) {
        return configuration.getInt(path);
    }

    @Override
    public List<Integer> getIntegerList(String path) {
        return configuration.getIntegerList(path);
    }

    @Override
    public Double getDouble(String path) {
        return configuration.getDouble(path);
    }

    @Override
    public List<Double> getDoubleList(String path) {
        return configuration.getDoubleList(path);
    }

    @Override
    public Float getFloat(String path) {
        return Float.parseFloat(getString(path));
    }

    @Override
    public List<Float> getFloatList(String path) {
        return configuration.getFloatList(path);
    }

    @Override
    public Object get(String path) {
        return configuration.get(path);
    }
}
