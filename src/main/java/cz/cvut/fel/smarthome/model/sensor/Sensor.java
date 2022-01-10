package cz.cvut.fel.smarthome.model.sensor;

import cz.cvut.fel.smarthome.model.actor.action.Action;
import cz.cvut.fel.smarthome.model.device.Device;
import cz.cvut.fel.smarthome.model.event.Event;

import java.util.Set;

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
