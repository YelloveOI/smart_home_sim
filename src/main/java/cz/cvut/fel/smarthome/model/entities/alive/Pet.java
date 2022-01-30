package cz.cvut.fel.smarthome.model.entities.alive;

import cz.cvut.fel.smarthome.model.ActivityType;
import cz.cvut.fel.smarthome.model.entities.Order;

import java.util.Objects;

public class Pet extends AbstractAlive {

    public Pet(String name) {
        super("PET_" + name);
    }

    @Override
    public Boolean order(Order order) {

        return false;
    }


}
