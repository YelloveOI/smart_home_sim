package cz.cvut.fel.smarthome.model.location;

import cz.cvut.fel.smarthome.model.device.Device;

import javax.naming.ConfigurationException;
import java.util.ArrayList;
import java.util.List;

final public class Room extends Location {
    final List<Device> placedDevices = new ArrayList<>();

    public Room placeDevice(Device device){
        placedDevices.add(device);
        return this;
    }

    public Room(Location root) {
        super(root);
    }

    @Override
    public Room addNestedLocation() {
        nestedLocations.add(new Window(this));
        return this;
    }

    @Override
    public Room removeNestedLocation(int index) {
        nestedLocations.remove(index);
        return this;
    }

    @Override
    public Window getNestedLocation(int index) {
        return (Window) nestedLocations.get(index);
    }

    @Override
    public Floor getRoot() {
        return (Floor) root;
    }

    @Override
    public String toString() {
        return "Room{" +
                "nestedLocations=" + nestedLocations +
                '}';
    }
}
