package cz.cvut.fel.smarthome.model.location;

import javax.naming.ConfigurationException;

final public class House extends Location {
    @Override
    public House addNestedLocation() {
        nestedLocations.add(new Floor(this));
        return this;
    }

    public House addNestedGarage(){
        nestedLocations.add(new Garage(this));
        return this;
    }

    @Override
    public House removeNestedLocation(int index) {
        nestedLocations.remove(index);
        return this;
    }

    @Override
    public Location getNestedLocation(int index) {
        return nestedLocations.get(index);
    }

    @Override
    public Location getRoot() {
        return null;
    }

    @Override
    public String toString() {
        return "House{" +
                "nestedLocations=" + nestedLocations +
                '}';
    }
}
