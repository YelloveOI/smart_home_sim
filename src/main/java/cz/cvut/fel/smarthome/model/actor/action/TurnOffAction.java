package cz.cvut.fel.smarthome.model.actor.action;

import cz.cvut.fel.smarthome.model.actor.person.Person;
import cz.cvut.fel.smarthome.model.actor.pet.Pet;
import cz.cvut.fel.smarthome.model.device.Device;
import cz.cvut.fel.smarthome.model.event.EventProcessor;
import cz.cvut.fel.smarthome.model.event.event_context.PersonEventContext;
import cz.cvut.fel.smarthome.model.event.event_context.PetEventContext;
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
