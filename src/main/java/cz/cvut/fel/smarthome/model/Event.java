package cz.cvut.fel.smarthome.model;

import cz.cvut.fel.smarthome.model.actors.Actor;
import cz.cvut.fel.smarthome.model.device.Device;

public class Event {
    private Actor eventCreatorAct;

    private Device eventCreatorDev;

    private String eventType;

    private int priority;

    public Event(Actor eventCreatorAct, String eventType, int priority) {
        this.eventCreatorAct = eventCreatorAct;
        this.eventType = eventType;
        this.priority = priority;
    }

    public Event(Device eventCreatorDev, String eventType, int priority) {
        this.eventCreatorDev = eventCreatorDev;
        this.eventType = eventType;
        this.priority = priority;
    }
}
