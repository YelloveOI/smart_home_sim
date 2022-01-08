package cz.cvut.fel.smarthome.model.location;

import javax.naming.ConfigurationException;

public class Room extends Location {
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
