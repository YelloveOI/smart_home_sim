package cz.cvut.fel.smarthome.model.entities.pet;

import cz.cvut.fel.smarthome.model.entities.AbstractEntity;
import cz.cvut.fel.smarthome.model.interfaces.IActor;
import cz.cvut.fel.smarthome.model.action.Action;
import cz.cvut.fel.smarthome.model.entities.pet.state.PetState;

//TODO add state mechanics (hunger etc)
public class Pet extends AbstractEntity<String> implements IActor {

    private PetState state;
    private String location;

    public Pet(String name, String location) {
        super(name);
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void act(Action action) {
        action.visit(this);
    }
}
