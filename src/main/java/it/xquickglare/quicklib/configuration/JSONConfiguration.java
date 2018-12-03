package it.xquickglare.quicklib.configuration;

import it.xquickglare.quicklib.QuickLib;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class JSONConfiguration extends Configuration{
    
    private final File file;
    private JSONObject jsonObject;
    
    public JSONConfiguration(String name, QuickLib lib){
        file = new File(lib.getPlugin().getDataFolder(), name + ".json");

        if(!file.exists())
            lib.getPlugin().saveResource(name + ".json", false);
        
        reload();
    }
    
    @Override
    public boolean saveConfiguration() {
        try {
            FileUtils.writeStringToFile(file, jsonObject.toString(2), Charset.defaultCharset(), false);
        } catch (IOException e) {
            //TODO Logs
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

    @Override
    public boolean reload() {
        try {
            jsonObject = new JSONObject(FileUtils.readFileToString(file, Charset.defaultCharset()));
        } catch (IOException e) {
            //TODO Logs
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

    @Override
    public void set(String path, Object value) {
        jsonObject.put(path, value);
    }

    @Override
    public String getString(String path) {
        return jsonObject.getString(path);
    }

    @Override
    public List<String> getStringList(String path) {
        return (List<String>) (List<?>) jsonObject.getJSONArray(path).toList();
    }

    @Override
    public boolean getBoolean(String path) {
        return jsonObject.getBoolean(path);
    }

    @Override
    public Integer getInteger(String path) {
        return jsonObject.getInt(path);
    }

    @Override
    public List<Integer> getIntegerList(String path) {
        return (List<Integer>) (List<?>) jsonObject.getJSONArray(path).toList();
    }

    @Override
    public Double getDouble(String path) {
        return jsonObject.getDouble(path);
    }

    @Override
    public List<Double> getDoubleList(String path) {
        return (List<Double>) (List<?>) jsonObject.getJSONArray(path).toList();
    }

    @Override
    public Float getFloat(String path) {
        return jsonObject.getFloat(path);
    }

    @Override
    public List<Float> getFloatList(String path) {
        return (List<Float>) (List<?>) jsonObject.getJSONArray(path).toList();
    }

    @Override
    public Object get(String path) {
        return jsonObject.get(path);
    }
}
