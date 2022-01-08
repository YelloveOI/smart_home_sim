package cz.cvut.fel.smarthome.model.location;

import javax.naming.ConfigurationException;

public class Window extends Location {
    public Window(Location root) {
        super(root);
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
