package cz.cvut.fel.smarthome.model.entities.sensor;

import cz.cvut.fel.smarthome.model.entities.AbstractEntity;
import cz.cvut.fel.smarthome.model.event.Event;
import cz.cvut.fel.smarthome.model.event.EventProcessor;
import cz.cvut.fel.smarthome.model.interfaces.ILocateable;

public class Sensor extends AbstractEntity<String> implements ILocateable {

    private final Event event;
    private String location;

    public Sensor(String name, Event event, String location) {
        super(name);
        this.event = event;
        this.location = location;
    }

    public void trigger() {
        EventProcessor.getEvent(event);
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }
}
