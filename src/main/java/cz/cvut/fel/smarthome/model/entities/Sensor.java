package cz.cvut.fel.smarthome.model.entities;

import cz.cvut.fel.smarthome.model.entities.basic.Locatable;
import cz.cvut.fel.smarthome.model.event.Event;
import cz.cvut.fel.smarthome.model.entities.basic.interfaces.ILocateable;

public class Sensor extends AbstractEntity<String> implements ILocateable {

    private final Event event;
    private final Locatable locateable;

    public Sensor(String name, Event event, String preferredLocation) {
        super(name);
        this.event = event;
        this.locateable = new Locatable(preferredLocation);
    }

    public void trigger() {
        //TODO
    }

    @Override
    public String getLocation() {
        return locateable.getLocation();
    }

    @Override
    public void setLocation(String location) {
        locateable.setLocation(location);
    }

    @Override
    public void locateBack() {
        locateable.locateBack();
    }
}
