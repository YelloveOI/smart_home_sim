package cz.cvut.fel.smarthome.model.actor.pet;

import cz.cvut.fel.smarthome.model.interfaces.IActor;
import cz.cvut.fel.smarthome.model.actor.action.Action;
import cz.cvut.fel.smarthome.model.actor.pet.state.PetState;

//TODO add state mechanics (hunger etc)
public class Pet implements IActor {

    private final String name;
    private PetState state;

    public Pet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void act(Action action) {
        action.visit(this);
    }
}
