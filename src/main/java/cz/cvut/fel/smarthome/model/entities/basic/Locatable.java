package cz.cvut.fel.smarthome.model.entities.basic;

import cz.cvut.fel.smarthome.model.entities.basic.interfaces.ILocateable;

public class Locatable implements ILocateable {

    private String location;
    private final String preferredLocation;

    public Locatable(String preferredLocation) {
        this.preferredLocation = preferredLocation;
        this.location = preferredLocation;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void locateBack() {
        location = preferredLocation;
    }
}
