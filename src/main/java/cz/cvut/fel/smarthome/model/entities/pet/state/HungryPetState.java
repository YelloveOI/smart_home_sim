package cz.cvut.fel.smarthome.model.entities.pet.state;

import cz.cvut.fel.smarthome.model.action.Action;
import cz.cvut.fel.smarthome.model.entities.pet.Pet;

public class HungryPetState extends PetState{
    public HungryPetState(Pet pet) {
        super(pet);
    }

    @Override
    public void act(Action action) {
    }

    @Override
    public Boolean isHungry() {
        return true;
    }

}
