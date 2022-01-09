package cz.cvut.fel.smarthome.model.actor.action;

import cz.cvut.fel.smarthome.model.actor.Person;
import cz.cvut.fel.smarthome.model.actor.Pet;
import cz.cvut.fel.smarthome.model.auxiliary.IUse;
import cz.cvut.fel.smarthome.model.device.Device;

public class StopUseAction extends Action<IUse> {

    public StopUseAction(Device subject) {
        super(subject);
    }

    @Override
    public void visit(Person actor) {
        subject.stopUse();;
        //TODO ActionReport
    }

    @Override
    public void visit(Pet actor) {
        //TODO ActionReport
    }
}
