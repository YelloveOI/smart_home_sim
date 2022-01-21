package cz.cvut.fel.smarthome.model.entities.pet.state;

import cz.cvut.fel.smarthome.model.action.Action;
import cz.cvut.fel.smarthome.model.entities.pet.Pet;

public class TiredPetState extends PetState{
    public TiredPetState(Pet pet) {
        super(pet);
    }

    @Override
    public void act(Action action) {
//        EventProcessor
//                .createReport(this.getClass(), pet.getName(),"too tired to do anything")
//                .execute();
    }

    @Override
    public void sleep() {
//        pet.setTireMeter(5);
//        pet.setPetState(new FreePetState(pet));
//        EventProcessor
//                .createReport(this.getClass(), pet.getName(),"pet slept and is now refreshed")
//                .execute();
    }
}
