package cz.cvut.fel.smarthome.model.action;

import cz.cvut.fel.smarthome.model.entities.person.Person;
import cz.cvut.fel.smarthome.model.entities.pet.Pet;
import cz.cvut.fel.smarthome.model.entities.device.Device;

public class TurnOnAction extends Action<Device> {

    public TurnOnAction(Device subject) {
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
