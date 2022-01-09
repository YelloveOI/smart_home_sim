package cz.cvut.fel.smarthome.model.actor.action;

import cz.cvut.fel.smarthome.model.actor.Person;
import cz.cvut.fel.smarthome.model.actor.Pet;
import cz.cvut.fel.smarthome.model.device.Device;
import cz.cvut.fel.smarthome.model.device.IControl;

public class TurnOffAction extends Action<IControl> {

    public TurnOffAction(Device subject) {
        super(subject);
    }

    @Override
    public void visit(Person actor) {
        subject.turnOff();
        //TODO ActionReport
    }

    @Override
    public void visit(Pet actor) {
        //TODO ActionReport
    }
}
