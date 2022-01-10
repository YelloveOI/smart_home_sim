package cz.cvut.fel.smarthome.model.actor.pet.state;

import cz.cvut.fel.smarthome.model.actor.action.Action;
import cz.cvut.fel.smarthome.model.actor.pet.Pet;

public abstract class PetState {

    private final Pet pet;

    public PetState(Pet pet) {
        this.pet = pet;
    }

    abstract public void act(Action action);

}
