package cz.cvut.fel.smarthome.model.entities.movable;

import cz.cvut.fel.smarthome.model.entities.Order;
import cz.cvut.fel.smarthome.model.entities.basic.AbstractEntity;
import cz.cvut.fel.smarthome.model.entities.basic.Active;
import cz.cvut.fel.smarthome.model.entities.basic.Locatable;

import java.util.Objects;

public abstract class AbstractAlive extends AbstractEntity<String> {

    protected final Active active;
    protected final Locatable locatable;

    public AbstractAlive(String name, String assignedLocation) {
        super(name);
        this.active = new Active();
        this.locatable = new Locatable(assignedLocation);
    }

    public Boolean move(String location) {
        if(Objects.equals(active.getCurrentActivity(), "FREE")) {
            locatable.setLocation(location);
            return true;
        }
        return false;
    }

    abstract public Boolean order(Order order);

}
