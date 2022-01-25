package cz.cvut.fel.smarthome.model.entities.movable;

import cz.cvut.fel.smarthome.model.event.Event;

import java.util.PriorityQueue;
import java.util.Queue;

public class Person extends Alive {

    private final Queue<Event> receivedEvents;

    public Person(String name, String assignedLocation) {
        super(name, assignedLocation);
        receivedEvents = new PriorityQueue<>();
    }

    public void addEvent(Event event) {
        receivedEvents.add(event);
    }

}
