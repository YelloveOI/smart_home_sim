package cz.cvut.fel.smarthome.model.location;

import javax.naming.ConfigurationException;

public class Garage extends Location {
    @Override
    public Garage addNestedLocation() {
        return null;
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
