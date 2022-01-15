package cz.cvut.fel.smarthome.model.actor.action;

import cz.cvut.fel.smarthome.model.actor.person.Person;
import cz.cvut.fel.smarthome.model.actor.pet.Pet;
import cz.cvut.fel.smarthome.model.event.EventProcessor;
import cz.cvut.fel.smarthome.model.event.event_context.PersonEventContext;
import cz.cvut.fel.smarthome.model.event.event_context.PetEventContext;
import cz.cvut.fel.smarthome.model.interfaces.IUseable;

public class BadUseAction extends Action<IUseable> {

    public BadUseAction(IUseable subject) {
        super(subject);
    }

    @Override
    public void visit(Person actor) {
        subject.badUse();
    }

    @Override
    public void visit(Pet actor) {
        subject.badUse();
        subject.badUse();
    }
}
