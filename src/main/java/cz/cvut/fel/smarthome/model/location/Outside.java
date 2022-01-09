package cz.cvut.fel.smarthome.model.location;

import javax.naming.ConfigurationException;

final public class Outside extends Location {
    @Override
    public Outside addNestedLocation() {
        return this;
    }

    @Override
    public Outside removeNestedLocation(int index) {
        return this;
    }

    @Override
    public Outside getNestedLocation(int index) {
        return this;
    }

    @Override
    public Outside getRoot() {
        return this;
    }

    @Override
    public String toString() {
        return "Outside{" +
                "nestedLocations=" + nestedLocations +
                '}';
    }
}
