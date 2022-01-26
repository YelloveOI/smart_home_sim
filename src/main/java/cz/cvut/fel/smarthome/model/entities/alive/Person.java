package cz.cvut.fel.smarthome.model.entities.alive;

import cz.cvut.fel.smarthome.model.entities.Order;

import java.util.Objects;
import java.util.PriorityQueue;

public class Person extends AbstractAlive {

    public Person(String name) {
        super("PERSON_" + name);
        receivedEvents = new PriorityQueue<>();
    }

    public String getCurrentActivity() {
        return active.getCurrentActivity();
    }

    @Override
    public Boolean order(Order order) {
        if(!Objects.equals(active.getCurrentActivity(), "FREE")) {
            return false;
        }
        switch(order) {
            case WORK -> {
                active.startActivity("WORK");
                return true;
            }
            case SPORT -> {
                active.startActivity("SPORT");
                return true;
            }
            case PROCRASTINATE -> {
                active.startActivity("PROCRASTINATE");
                return true;
            }
            case PROCESS_EVENT -> {
                active.startActivity("PROCESS_EVENT");
                return true;
            }
            case GET_FREE -> {
                active.stopActivity();
                return true;
            }
        }
        return false;
    }

}
