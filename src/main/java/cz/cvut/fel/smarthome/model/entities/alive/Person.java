package cz.cvut.fel.smarthome.model.entities.alive;

import cz.cvut.fel.smarthome.model.entities.Order;
import cz.cvut.fel.smarthome.model.activity.ActivityType;

import java.util.Objects;

public class Person extends AbstractAlive {

    public Person(String name) {
        super("PERSON_" + name);
    }

    @Override
    public Boolean order(Order order) {
        if(!(Objects.equals(active.getCurrentActivity(), "FREE") || order == Order.O_GET_FREE)) {
            return false;
        }
        switch(order) {
            case O_WORK -> {
                active.startActivity(ActivityType.A_WORK);
                return true;
            }
            case O_SPORT -> {
                active.startActivity(ActivityType.A_SPORT);
                return true;
            }
            case O_PROCRASTINATE -> {
                active.startActivity(ActivityType.A_PROCRASTINATE);
                return true;
            }
            case O_PROCESS_EVENT -> {
                active.startActivity(ActivityType.A_PROCESS_EVENT);
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
