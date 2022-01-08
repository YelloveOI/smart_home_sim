package cz.cvut.fel.smarthome.model.location;

import cz.cvut.fel.smarthome.model.device.Device;

import javax.naming.ConfigurationException;
import java.util.ArrayList;
import java.util.List;

final public class Garage extends Location {
    public Garage(Location root) {
        super(root);
    }

    final List<Device> placedDevices = new ArrayList<>();

    public Garage placeDevice(Device device){
        placedDevices.add(device);
        return this;
    }

    @Override
    public Garage addNestedLocation() {
        return this;
    }

    @Override
    public Garage removeNestedLocation(int index) {
        return this;
    }

    @Override
    public Garage getNestedLocation(int index) {
        return this;
    }

    @Override
    public Garage getRoot() {
        return this;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "nestedLocations=" + nestedLocations +
                '}';
    }
}
