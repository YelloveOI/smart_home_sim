package cz.cvut.fel.smarthome.model.entities.person.state;

import cz.cvut.fel.smarthome.model.action.Action;
import cz.cvut.fel.smarthome.model.entities.person.Person;
import cz.cvut.fel.smarthome.model.event.EventProcessor;
import cz.cvut.fel.smarthome.model.event.event_context.PersonEventContext;

public class FreePersonState extends PersonState {

    public FreePersonState(Person person) {
        super(person);
    }

    @Override
    public void act(Action action) {
        action.visit(person);
        EventProcessor.getEvent(PersonEventContext.act(person, action));
    }

    @Override
    public void becomeBusy() {
        person.setPersonState(new BusyPersonState(person));
    }

    @Override
    public void getFree() {
    }

    @Override
    public Boolean isFree() {
        return true;
    }

}
