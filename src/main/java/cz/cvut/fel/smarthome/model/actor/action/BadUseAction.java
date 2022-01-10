package cz.cvut.fel.smarthome.model.actor.action;

import cz.cvut.fel.smarthome.model.actor.person.Person;
import cz.cvut.fel.smarthome.model.actor.pet.Pet;
import cz.cvut.fel.smarthome.model.event.ReportContext;
import cz.cvut.fel.smarthome.model.interfaces.IUseable;

public class BadUseAction extends Action<IUseable> {

    public BadUseAction(IUseable subject) {
        super(subject);
    }

    @Override
    public void visit(Person actor) {
        subject.badUse();
        ReportContext
                .createReportEvent(this.getClass(), actor.getName(),"accidentally dropped a bottle of beer on " + subject.getClass().getSimpleName() + " " + subject.getName())
                .execute();
    }

    @Override
    public void visit(Pet actor) {
        subject.badUse();
        subject.badUse();
        ReportContext
                .createReportEvent(this.getClass(), actor.getName(),"nasty scratched " + subject.getClass().getSimpleName() + " " + subject.getName())
                .execute();
    }
}
