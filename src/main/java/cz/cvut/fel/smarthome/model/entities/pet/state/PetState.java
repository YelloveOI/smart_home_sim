package cz.cvut.fel.smarthome.model.entities.pet.state;

import cz.cvut.fel.smarthome.model.action.Action;
import cz.cvut.fel.smarthome.model.entities.pet.Pet;

public abstract class PetState {

    protected final Pet pet;

    public PetState(Pet pet) {
        this.pet = pet;
    }

    abstract public void act(Action action);
    abstract public void sleep();

}
