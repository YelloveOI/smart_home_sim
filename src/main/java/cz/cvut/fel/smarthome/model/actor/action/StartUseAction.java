package cz.cvut.fel.smarthome.model.actor.action;

import cz.cvut.fel.smarthome.model.actor.person.Person;
import cz.cvut.fel.smarthome.model.actor.person.state.BusyPersonState;
import cz.cvut.fel.smarthome.model.actor.pet.Pet;
import cz.cvut.fel.smarthome.model.event.ReportContext;
import cz.cvut.fel.smarthome.model.interfaces.IUseable;
import cz.cvut.fel.smarthome.model.device.Device;

public class StartUseAction extends Action<IUseable> {

    public StartUseAction(Device subject) {
        super(subject);
    }

    @Override
    public void visit(Person actor) {
        subject.startUse();
        actor.setPersonState(new BusyPersonState(actor));
        ReportContext
                .createReportEvent(this.getClass(), actor.getName(),"start using " + subject.getClass().getSimpleName() + " " + subject.getName())
                .execute();
    }

    @Override
    public void visit(Pet actor) {
        ReportContext
                .createReportEvent(this.getClass(), actor.getName(),"trying start using " + subject.getClass().getSimpleName() + " " + subject.getName())
                .execute();
    }
}
