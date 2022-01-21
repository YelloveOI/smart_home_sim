package cz.cvut.fel.smarthome.model.entities.pet.state;

import cz.cvut.fel.smarthome.model.action.Action;
import cz.cvut.fel.smarthome.model.entities.pet.Pet;

public class FreePetState extends PetState{

    public FreePetState(Pet pet) {
        super(pet);
    }

    @Override
    public void act(Action action) {
        action.visit(pet);
//        pet.getMoreTired();
//        EventProcessor
//                .createReport(this.getClass(), pet.getName(),"pet did some activity!")
//                .execute();
    }

    @Override
    public void sleep() {
//        EventProcessor
//                .createReport(this.getClass(), pet.getName(),"not tired")
//                .execute();
    }
}
