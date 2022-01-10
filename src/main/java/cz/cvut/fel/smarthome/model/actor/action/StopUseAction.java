package cz.cvut.fel.smarthome.model.actor.action;

import cz.cvut.fel.smarthome.model.actor.person.Person;
import cz.cvut.fel.smarthome.model.actor.person.state.FreePersonState;
import cz.cvut.fel.smarthome.model.actor.pet.Pet;
import cz.cvut.fel.smarthome.model.event.ReportContext;
import cz.cvut.fel.smarthome.model.interfaces.IUseable;
import cz.cvut.fel.smarthome.model.device.Device;

public class StopUseAction extends Action<IUseable> {

    public StopUseAction(Device subject) {
        super(subject);
    }

    @Override
    public void visit(Person actor) {
        subject.stopUse();
        actor.setPersonState(new FreePersonState(actor));
        ReportContext
                .createReportEvent(this.getClass(), actor.getName(),"stop using " + subject.getClass().getSimpleName() + " " + subject.getName())
                .execute();
    }

    @Override
    public void visit(Pet actor) {
        ReportContext
                .createReportEvent(this.getClass(), actor.getName(),"passed by " + subject.getClass().getSimpleName() + " " + subject.getName())
                .execute();
    }
}
