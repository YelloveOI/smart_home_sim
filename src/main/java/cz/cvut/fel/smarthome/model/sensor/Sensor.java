package cz.cvut.fel.smarthome.model.sensor;

import cz.cvut.fel.smarthome.model.event.Event;

public class Sensor {

    private final String name;
    private final Event event;

    public Sensor(String name, Event event) {
        this.name = name;
        this.event = event;
    }

    public void trigger() {
        event.execute();
    }

}
