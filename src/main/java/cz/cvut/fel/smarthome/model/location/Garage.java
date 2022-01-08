package cz.cvut.fel.smarthome.model.location;

import javax.naming.ConfigurationException;

final public class Garage extends Location {
    public Garage(Location root) {
        super(root);
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
