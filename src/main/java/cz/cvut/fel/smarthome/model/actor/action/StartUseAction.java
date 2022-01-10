package cz.cvut.fel.smarthome.model.actor.action;

import cz.cvut.fel.smarthome.model.actor.person.Person;
import cz.cvut.fel.smarthome.model.actor.pet.Pet;
import cz.cvut.fel.smarthome.model.interfaces.IUseable;
import cz.cvut.fel.smarthome.model.device.Device;

public class StartUseAction extends Action<IUseable> {

    public StartUseAction(Device subject) {
        super(subject);
    }

    @Override
    public void visit(Person actor) {
        subject.startUse();
        //TODO ActionReport
    }

    @Override
    public void visit(Pet actor) {
        //TODO ActionReport
    }
}
