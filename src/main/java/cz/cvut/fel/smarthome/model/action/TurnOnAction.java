package cz.cvut.fel.smarthome.model.action;

import cz.cvut.fel.smarthome.model.entities.person.Person;
import cz.cvut.fel.smarthome.model.entities.pet.Pet;

public class TurnOnAction extends Action<DeviceOLD> {

    public TurnOnAction(DeviceOLD subject) {
        super(subject);
    }

    @Override
    public void visit(Person actor) {
        subject.turnOn();
    }

    @Override
    public void visit(Pet actor) {
        subject.wearOut();
    }
}
