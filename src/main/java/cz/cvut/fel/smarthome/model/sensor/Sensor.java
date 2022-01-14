package cz.cvut.fel.smarthome.model.sensor;

import cz.cvut.fel.smarthome.model.AbstractEntity;
import cz.cvut.fel.smarthome.model.event.Event;

//TODO
public class Sensor extends AbstractEntity {

    private final Event event;

    public Sensor(String name, Event event) {
        super(name);
        this.event = event;
    }

    public void trigger() {
        event.execute();
    }

}
