package cz.cvut.fel.smarthome.model.actor.person.state;

import cz.cvut.fel.smarthome.model.actor.person.Person;
import cz.cvut.fel.smarthome.model.actor.action.Action;
import cz.cvut.fel.smarthome.model.auxiliary.Auxiliary;
import cz.cvut.fel.smarthome.model.device.Device;
import cz.cvut.fel.smarthome.model.event.ReportContext;
import cz.cvut.fel.smarthome.model.interfaces.IUseable;

public class FreePersonState extends PersonState {

    public FreePersonState(Person person) {
        super(person);
    }

    @Override
    public void act(Action action) {
        action.visit(person);
        ReportContext
                .createReportEvent(this.getClass(), person.getName(),"takes on a new business")
                .execute();
    }

    @Override
    public void goSport(Auxiliary sportAux) {
        //TODO
        if(!sportAux.startUse()) {
            ReportContext
                    .createReportEvent(this.getClass(), person.getName(),"cant use Sport Auxiliary " + sportAux.getName() + " because it's unavailable")
                    .execute();
        } else {
            //go out of home
            ReportContext
                    .createReportEvent(this.getClass(), person.getName(),"going sport")
                    .execute();
            //activity reporter record
            person.setPersonState(new BusyPersonState(person, sportAux));
        }
    }

    @Override
    public void goWork(Auxiliary workAux) {
        //TODO
        if(!workAux.startUse()) {
            ReportContext
                    .createReportEvent(this.getClass(), person.getName(),"cant use Work Auxiliary " + workAux.getName() + " because it's unavailable")
                    .execute();
        } else {
            //go out of home
            ReportContext
                    .createReportEvent(this.getClass(), person.getName(),"going work")
                    .execute();
            //activity reporter record
            person.setPersonState(new BusyPersonState(person, workAux));
        }
    }

    @Override
    public void goProcrastinate(Device procrastinator) {
        //TODO
        if(!procrastinator.startUse()) {
            ReportContext
                    .createReportEvent(this.getClass(), person.getName(),"cant use Device " + procrastinator.getName() + " because it's unavailable")
                    .execute();
        } else {
            ReportContext
                    .createReportEvent(this.getClass(), person.getName(), "start procrastinating with " + procrastinator.getName());
        }
    }

    @Override
    public void getFreeFromActivity() {
        ReportContext
                .createReportEvent(this.getClass(), person.getName(),"already free now")
                .execute();
    }

}
