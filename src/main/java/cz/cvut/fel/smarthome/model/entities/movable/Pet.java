package cz.cvut.fel.smarthome.model.entities.movable;

import cz.cvut.fel.smarthome.model.entities.Order;

public class Pet extends AbstractAlive {
    //TODO
    public Pet(String name, String assignedLocation) {
        super(name, assignedLocation);
    }

    @Override
    public Boolean order(Order order) {
        return null;
    }


}
