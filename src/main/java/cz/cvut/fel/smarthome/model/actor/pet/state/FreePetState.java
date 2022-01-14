package cz.cvut.fel.smarthome.model.actor.pet.state;

import cz.cvut.fel.smarthome.model.actor.action.Action;
import cz.cvut.fel.smarthome.model.actor.pet.Pet;
import cz.cvut.fel.smarthome.model.event.EventProcessor;

public class FreePetState extends PetState{

    public FreePetState(Pet pet) {
        super(pet);
    }

    @Override
    public void act(Action action) {
        action.visit(pet);
//        pet.getMoreTired();
        EventProcessor
                .createReport(this.getClass(), pet.getName(),"pet did some activity!")
                .execute();
    }

    @Override
    public void sleep() {
        EventProcessor
                .createReport(this.getClass(), pet.getName(),"not tired")
                .execute();
    }
}
