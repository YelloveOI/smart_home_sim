package cz.cvut.fel.smarthome.model.entities;

import cz.cvut.fel.smarthome.model.entities.basic.Locatable;
import cz.cvut.fel.smarthome.model.event.Event;
import cz.cvut.fel.smarthome.model.entities.basic.interfaces.ILocateable;

public class Sensor extends AbstractEntity<String> implements ILocateable {

    //TODO
    private final Event event;
    private final Locatable locatable;

    public Sensor(String name, Event event, String preferredLocation) {
        super(name);
        this.event = event;
        this.locatable = new Locatable(preferredLocation);
    }

    public void trigger() {
        //TODO
    }

    @Override
    public String getLocation() {
        return locatable.getLocation();
    }

    @Override
    public void setLocation(String location) {
        locatable.setLocation(location);
    }

    @Override
    public void locateBack() {
        locatable.locateBack();
    }
}
