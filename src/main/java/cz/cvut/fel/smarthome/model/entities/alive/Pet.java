package cz.cvut.fel.smarthome.model.entities.alive;

import cz.cvut.fel.smarthome.model.entities.Order;

public class Pet extends AbstractAlive {
    //TODO
    public Pet(String name) {
        super("PET_" + name);
    }

    @Override
    public Boolean order(Order order) {
        return null;
    }


}
