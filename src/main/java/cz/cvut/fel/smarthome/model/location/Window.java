package cz.cvut.fel.smarthome.model.location;

import cz.cvut.fel.smarthome.model.device.Device;

import javax.naming.ConfigurationException;
import java.util.ArrayList;
import java.util.List;

final public class Window extends Location {
    public Window(Location root) {
        super(root);
    }

    final List<Device> placedDevices = new ArrayList<>();

    public Window placeDevice(Device device){
        placedDevices.add(device);
        return this;
    }

    @Override
    public Window addNestedLocation() {
        return this;
    }

    @Override
    public Window removeNestedLocation(int index) {
        return this;
    }

    @Override
    public Window getNestedLocation(int index) {
        return this;
    }

    @Override
    public Room getRoot() {
        return (Room) root;
    }

    @Override
    public String toString() {
        return "Window{" +
                "nestedLocations=" + nestedLocations +
                '}';
    }
}
