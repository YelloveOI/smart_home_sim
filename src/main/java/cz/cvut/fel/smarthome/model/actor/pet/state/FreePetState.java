package cz.cvut.fel.smarthome.model.actor.pet.state;

import cz.cvut.fel.smarthome.model.actor.action.Action;
import cz.cvut.fel.smarthome.model.actor.pet.Pet;
import cz.cvut.fel.smarthome.model.event.ReportContext;

public class FreePetState extends PetState{

    public FreePetState(Pet pet) {
        super(pet);
    }

    @Override
    public void act(Action action) {
        action.visit(pet);
        pet.getMoreTired();
        ReportContext
                .createReportEvent(this.getClass(), pet.getName(),"pet did some activity!")
                .execute();
    }

    @Override
    public void sleep() {
        ReportContext
                .createReportEvent(this.getClass(), pet.getName(),"not tired")
                .execute();
    }
}
