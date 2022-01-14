package cz.cvut.fel.smarthome.model.actor.person.state;

import cz.cvut.fel.smarthome.model.actor.person.Person;
import cz.cvut.fel.smarthome.model.actor.action.Action;
import cz.cvut.fel.smarthome.model.auxiliary.Auxiliary;
import cz.cvut.fel.smarthome.model.device.Device;
import cz.cvut.fel.smarthome.model.event.EventChannelContext;
import cz.cvut.fel.smarthome.model.event.event_context.PersonEventContext;
import cz.cvut.fel.smarthome.model.interfaces.IUseable;

public class BusyPersonState extends PersonState {

    private final IUseable nowInUse;

    public BusyPersonState(Person person, IUseable nowInUse) {
        super(person);
        this.nowInUse = nowInUse;
    }

    @Override
    public void act(Action action) {
        PersonEventContext.imBusy(person);
    }

    @Override
    public void goSport(Auxiliary sportAux) {
        PersonEventContext.imBusy(person);
    }

    @Override
    public void goWork(Auxiliary workAux) {
        PersonEventContext.imBusy(person);
    }

    @Override
    public void goProcrastinate(Device procrastinator) {
        PersonEventContext.imBusy(person);
    }

    @Override
    public void getFreeFromActivity() {
        //TODO locator get home
        nowInUse.stopUse();
        PersonEventContext.getFree(person);
        //activity reporter record
        person.setPersonState(new FreePersonState(person));
    }

}
