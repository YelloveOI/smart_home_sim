package cz.cvut.fel.smarthome.model.entities.movable;

import cz.cvut.fel.smarthome.model.entities.AbstractEntity;
import cz.cvut.fel.smarthome.model.entities.basic.Active;
import cz.cvut.fel.smarthome.model.entities.basic.Locatable;

import java.util.Objects;

public abstract class Alive extends AbstractEntity<String> {

    private final Active active;
    private final Locatable locatable;

    public Alive(String name, String assignedLocation) {
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

}
