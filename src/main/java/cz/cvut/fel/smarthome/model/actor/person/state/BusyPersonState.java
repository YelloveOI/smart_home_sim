package cz.cvut.fel.smarthome.model.actor.person.state;

import cz.cvut.fel.smarthome.model.actor.person.Person;
import cz.cvut.fel.smarthome.model.actor.action.Action;
import cz.cvut.fel.smarthome.model.auxiliary.Auxiliary;
import cz.cvut.fel.smarthome.model.device.Device;
import cz.cvut.fel.smarthome.model.event.ReportContext;
import cz.cvut.fel.smarthome.model.interfaces.IUseable;

public class BusyPersonState extends PersonState {

    private final IUseable nowInUse;

    public BusyPersonState(Person person, IUseable nowInUse) {
        super(person);
        this.nowInUse = nowInUse;
    }

    @Override
    public void act(Action action) {
        ReportContext
                .createReportEvent(this.getClass(), person.getName(),"cannot tear himself away from the previous case")
                .execute();
    }

    @Override
    public void goSport(Auxiliary sportAux) {
        ReportContext
                .createReportEvent(this.getClass(), person.getName(),"cannot tear himself away from the previous case")
                .execute();
    }

    @Override
    public void goWork(Auxiliary workAux) {
        ReportContext
                .createReportEvent(this.getClass(), person.getName(),"cannot tear himself away from the previous case")
                .execute();
    }

    @Override
    public void goProcrastinate(Device procrastinator) {
        ReportContext
                .createReportEvent(this.getClass(), person.getName(),"cannot tear himself away from the previous case")
                .execute();
    }

    @Override
    public void getFreeFromActivity() {
        //TODO get home
        nowInUse.stopUse();
        ReportContext
                .createReportEvent(this.getClass(), person.getName(),"- 'now im free!'")
                .execute();
        //activity reporter record
        person.setPersonState(new FreePersonState(person));
    }

}
