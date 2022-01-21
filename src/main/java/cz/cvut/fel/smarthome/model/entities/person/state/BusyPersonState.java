package cz.cvut.fel.smarthome.model.entities.person.state;

import cz.cvut.fel.smarthome.model.entities.person.Person;
import cz.cvut.fel.smarthome.model.action.Action;
import cz.cvut.fel.smarthome.model.event.EventProcessor;
import cz.cvut.fel.smarthome.model.event.event_context.PersonEventContext;
import cz.cvut.fel.smarthome.model.interfaces.IUseable;

public class BusyPersonState extends PersonState {

    public BusyPersonState(Person person) {
        super(person);
    }

    @Override
    public void act(Action action) {
        EventProcessor.getEvent(PersonEventContext.imBusy(person));
    }

    @Override
    public void becomeBusy(IUseable useable) {
    }

    @Override
    public void getFree() {
        person.setPersonState(new FreePersonState(person));
        person.setInUse(null);
    }

    @Override
    public Boolean isFree() {
        return false;
    }

}
