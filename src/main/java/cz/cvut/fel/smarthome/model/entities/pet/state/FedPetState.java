package cz.cvut.fel.smarthome.model.entities.pet.state;

import cz.cvut.fel.smarthome.model.action.Action;
import cz.cvut.fel.smarthome.model.entities.pet.Pet;

public class FedPetState extends PetState{

    public FedPetState(Pet pet) {
        super(pet);
    }

    @Override
    public void act(Action action) {
        action.visit(pet);
        pet.getHungry();
    }

    @Override
    public Boolean isHungry() {
        return false;
    }

}
