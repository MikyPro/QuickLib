package it.xquickglare.quicklib.configuration;

import it.xquickglare.quicklib.utils.LocationSerialize;
import it.xquickglare.quicklib.utils.Message;
import it.xquickglare.quicklib.utils.MultiLineMessage;
import org.bukkit.Location;

import java.util.List;

public abstract class Configuration {

    //TODO: Messages support(getMessage, getMultilineMessage, getTitle, getActionbar)
    
    /**
     * The method for save the modified configuration file
     * 
     * @return True if the configuration was successfully saved.
     */
    public abstract boolean saveConfiguration();

    /**
     * The method for reload all values from the configuration file
     * 
     * @return True if the configuration was successfully reloaded
     */
    public abstract boolean reload();

    /**
     * The method for set a value in the configuration file
     *
     * @param path The path of the value to set
     * @param value The value to set
     */
    public abstract void set(String path, Object value);
    
    /**
     * The method for get a String from the configuration file
     * 
     * @param path The path of the String in the configuration file
     * @return The String from the configuration file
     */
    public abstract String getString(String path);

    /**
     * The method for get a List of Strings from the configuration file
     * 
     * @param path The path of the List of String in the configuration file
     * @return The List of Strings from the configuration file
     */
    public abstract List<String> getStringList(String path);

    /**
     * The method for get a Boolean from the configuration file
     * 
     * @param path The path of the Boolean in the configuration file
     * @return The Boolean from the configuration file
     */
    public abstract boolean getBoolean(String path);

    /**
     * The method for get a Integer from the configuration file
     * 
     * @param path The path of the Integer in the configuration file
     * @return The Integer from the configuration file
     */
    public abstract Integer getInteger(String path);

    /**
     * The method for get a List of Integers from the configuration file
     * 
     * @param path The path of the List of Integers in the configuration file
     * @return The List of Integers from the configuration file
     */
    public abstract List<Integer> getIntegerList(String path);

    /**
     * The method for get a Double from configuration file
     * 
     * @param path The path of the Double in the configuration file
     * @return The Double from the configuration file
     */
    public abstract Double getDouble(String path);

    /**
     * The method for get a List of Doubles from the configuration file
     *
     * @param path The path of the List of Doubles in the configuration file
     * @return The List of Doubles from the configuration file
     */
    public abstract List<Double> getDoubleList(String path);

    /**
     * The method for get a Float from the configuration file
     * 
     * @param path The path of the Float in the configuration file
     * @return The Float from the configuration file
     */
    public abstract Float getFloat(String path);

    /**
     * The method for get a List of Floats from the configuration file
     *
     * @param path The path of the List of Floats in the configuration file
     * @return The List of Floats the configuration file
     */
    public abstract List<Float> getFloatList(String path);

    /**
     * The method for get an Object from the configuration file
     * 
     * @param path The path of the Object in the configuration file
     * @return The Object from the configuration file
     */
    public abstract Object get(String path);

    /**
     * The method for get a Location from the configuration file
     * 
     * @param path The path of the Location in the configuration file
     * @return The Location from the configuration file
     */
    public Location getLocation(String path) {
        return LocationSerialize.deserialize(getString(path));
    }

    /**
     * The method for set a Location in the configuration file
     * 
     * @param path The path of the Location
     * @param location The Location
     */
    public void setLocation(String path, Location location) {
        set(path, LocationSerialize.serialize(location));
    }

    /**
     * The method for get a message from the configuration file
     * 
     * @param path The path of the message
     * @return The parsed message
     */
    public Message getMessage(String path) {
        return new Message(getString(path));
    }

    /**
     * The method for get a multiline message from the configuration file
     * 
     * @param path The path of the message
     * @return The parsed message
     */
    public MultiLineMessage getMultiLineMessage(String path) {
        return new MultiLineMessage(getStringList(path));
    }
}
