package cz.cvut.fel.smarthome.model.actor.pet;

import cz.cvut.fel.smarthome.model.AbstractEntity;
import cz.cvut.fel.smarthome.model.interfaces.IActor;
import cz.cvut.fel.smarthome.model.actor.action.Action;
import cz.cvut.fel.smarthome.model.actor.pet.state.PetState;

//TODO add state mechanics (hunger etc)
public class Pet extends AbstractEntity implements IActor {

    private PetState state;

    public Pet(String name) {
        super(name);
    }

    @Override
    public void act(Action action) {
        action.visit(this);
    }
}
