package cz.cvut.fel.smarthome.model.action;

import cz.cvut.fel.smarthome.model.entities.person.Person;
import cz.cvut.fel.smarthome.model.entities.pet.Pet;
import cz.cvut.fel.smarthome.model.entities.device.Device;
import cz.cvut.fel.smarthome.model.interfaces.IControl;

public class TurnOffAction extends Action<IControl> {

    public TurnOffAction(Device subject) {
        super(subject);
    }

    @Override
    public void visit(Person actor) {
        subject.turnOff();
    }

    @Override
    public void visit(Pet actor) {
    }
}
