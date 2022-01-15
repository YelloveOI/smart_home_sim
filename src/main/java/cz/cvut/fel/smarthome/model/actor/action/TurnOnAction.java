package cz.cvut.fel.smarthome.model.actor.action;

import cz.cvut.fel.smarthome.model.actor.person.Person;
import cz.cvut.fel.smarthome.model.actor.pet.Pet;
import cz.cvut.fel.smarthome.model.device.Device;
import cz.cvut.fel.smarthome.model.event.EventProcessor;
import cz.cvut.fel.smarthome.model.event.event_context.PersonEventContext;
import cz.cvut.fel.smarthome.model.event.event_context.PetEventContext;

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
