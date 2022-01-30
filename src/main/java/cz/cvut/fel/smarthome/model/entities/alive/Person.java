package cz.cvut.fel.smarthome.model.entities.alive;

import cz.cvut.fel.smarthome.model.basic.ActivityType;
import cz.cvut.fel.smarthome.model.entities.Order;

import java.util.Objects;

public class Person extends AbstractAlive {

    public Person(String name) {
        super("PERSON_" + name);
    }

    @Override
    public Boolean order(Order order) {
        if(!(Objects.equals(active.getCurrentActivity(), ActivityType.A_FREE) || order == Order.O_GET_FREE)) {
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
            case O_USE_DEVICE -> {
                active.startActivity(ActivityType.A_USING_DEVICE);
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
