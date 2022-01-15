package cz.cvut.fel.smarthome.model.actor.person.state;

import cz.cvut.fel.smarthome.model.actor.action.Action;
import cz.cvut.fel.smarthome.model.actor.person.Person;
import cz.cvut.fel.smarthome.model.auxiliary.Auxiliary;
import cz.cvut.fel.smarthome.model.device.Device;
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
    public void goSport(Auxiliary sportAux) {
        if(!sportAux.startUse()) {
            EventProcessor.getEvent(PersonEventContext.cantUse(person, sportAux));
        } else {
            EventProcessor.getEvent(PersonEventContext.goSport(person));
            person.setPersonState(new BusyPersonState(person, sportAux));
        }
    }

    @Override
    public void goWork(Auxiliary workAux) {
        if(!workAux.startUse()) {
            EventProcessor.getEvent(PersonEventContext.cantUse(person, workAux));
        } else {
            EventProcessor.getEvent(PersonEventContext.goWork(person));
            person.setPersonState(new BusyPersonState(person, workAux));
        }
    }

    @Override
    public void goProcrastinate(Device procrastinator) {
        if(!procrastinator.startUse()) {
            EventProcessor.getEvent(PersonEventContext.cantUse(person, procrastinator));
        } else {
            EventProcessor.getEvent(PersonEventContext.goProcrastinate(person));
            person.setPersonState(new BusyPersonState(person, procrastinator));
        }
    }

    @Override
    public void getFreeFromActivity() {
        EventProcessor.getEvent(PersonEventContext.getFree(person));
    }

}
