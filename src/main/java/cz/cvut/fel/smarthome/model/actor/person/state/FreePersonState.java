package cz.cvut.fel.smarthome.model.actor.person.state;

import cz.cvut.fel.smarthome.model.actor.action.Action;
import cz.cvut.fel.smarthome.model.actor.person.Person;
import cz.cvut.fel.smarthome.model.auxiliary.Auxiliary;
import cz.cvut.fel.smarthome.model.device.Device;
import cz.cvut.fel.smarthome.model.event.event_context.PersonEventContext;

public class FreePersonState extends PersonState {

    public FreePersonState(Person person) {
        super(person);
    }

    @Override
    public void act(Action action) {
        action.visit(person);
        PersonEventContext.act(person, action);
    }

    @Override
    public void goSport(Auxiliary sportAux) {
        if(!sportAux.startUse()) {
            PersonEventContext.cantUse(person, sportAux);
        } else {
            //TODO locator go out of home
            PersonEventContext.goSport(person);
            //activity reporter record
            person.setPersonState(new BusyPersonState(person, sportAux));
        }
    }

    @Override
    public void goWork(Auxiliary workAux) {
        if(!workAux.startUse()) {
            PersonEventContext.cantUse(person, workAux);
        } else {
            //TODO locator go out of home
            PersonEventContext.goWork(person);
            //activity reporter record
            person.setPersonState(new BusyPersonState(person, workAux));
        }
    }

    @Override
    public void goProcrastinate(Device procrastinator) {
        if(!procrastinator.startUse()) {
            PersonEventContext.cantUse(person, procrastinator);
        } else {
            PersonEventContext.goProcrastinate(person);
            person.setPersonState(new BusyPersonState(person, procrastinator));
        }
    }

    @Override
    public void getFreeFromActivity() {
        PersonEventContext.getFree(person);
    }

}
