package cz.cvut.fel.smarthome.model.entities.alive;

import cz.cvut.fel.smarthome.model.entities.Order;

import java.util.Objects;
import java.util.PriorityQueue;

public class Person extends AbstractAlive {

    public Person(String name) {
        super("PERSON_" + name);
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
            case O_WORK -> {
                active.startActivity("WORK");
                return true;
            }
            case O_SPORT -> {
                active.startActivity("SPORT");
                return true;
            }
            case O_PROCRASTINATE -> {
                active.startActivity("PROCRASTINATE");
                return true;
            }
            case O_PROCESS_EVENT -> {
                active.startActivity("PROCESS_EVENT");
                return true;
            }
            case O_GET_FREE -> {
                active.stopActivity();
                return true;
            }
        }
        return false;
    }

}
