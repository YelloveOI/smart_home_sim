package cz.cvut.fel.smarthome.model.actor.action;

import cz.cvut.fel.smarthome.model.actor.Person;
import cz.cvut.fel.smarthome.model.actor.Pet;
import cz.cvut.fel.smarthome.model.auxiliary.IUse;
import cz.cvut.fel.smarthome.model.device.Device;
import cz.cvut.fel.smarthome.model.device.IControl;

public class StartUseAction extends Action<IUse> {

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
