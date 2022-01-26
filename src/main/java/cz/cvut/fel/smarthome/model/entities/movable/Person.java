package cz.cvut.fel.smarthome.model.entities.movable;

import cz.cvut.fel.smarthome.model.entities.Order;
import cz.cvut.fel.smarthome.model.event.Event;

import java.util.PriorityQueue;
import java.util.Queue;

public class Person extends AbstractAlive {

    private final Queue<Event> receivedEvents;

    public Person(String name, String assignedLocation) {
        super("PERSON_" + name, assignedLocation);
        receivedEvents = new PriorityQueue<>();
    }

    public void addEvent(Event event) {
        receivedEvents.add(event);
    }

    public Boolean isEventQueueEmpty() {
        return receivedEvents.isEmpty();
    }

    @Override
    public Boolean order(Order order) {
        if(active.getCurrentActivity() != "FREE") {
            return false;
        }
        switch(order) {
            case WORK -> {
                locatable.setLocation("OUTSIDE");
                active.setActivity("WORK", 20);
                return true;
            }
            case SPORT -> {
                locatable.setLocation("OUTSIDE");
                active.setActivity("SPORT", 5);
                return true;
            }
            case PROCRASTINATE -> {
                active.setActivity("PROCRASTINATE", 5);
                return true;
            }
            case BUSY_5 -> {
                active.setActivity("PROCESS_EVENT", 5);
                return true;
            }
            case BUSY_10 -> {
                active.setActivity("PROCESS_EVENT", 10);
                return true;
            }
            case BUSY_25 -> {
                active.setActivity("PROCESS_EVENT", 25);
                return true;
            }
        }
        return false;
    }

}
