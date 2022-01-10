package cz.cvut.fel.smarthome.model.actor.action;

import cz.cvut.fel.smarthome.model.actor.person.Person;
import cz.cvut.fel.smarthome.model.actor.pet.Pet;
import cz.cvut.fel.smarthome.model.device.Device;
import cz.cvut.fel.smarthome.model.event.ReportContext;

public class TurnOnAction extends Action<Device> {

    public TurnOnAction(Device subject) {
        super(subject);
    }

    @Override
    public void visit(Person actor) {
        subject.turnOn();
        ReportContext
                .createReportEvent(this.getClass(), actor.getName(),"turning on " + subject.getClass().getSimpleName() + " " + subject.getName())
                .execute();
    }

    @Override
    public void visit(Pet actor) {
        subject.wearOut();
        ReportContext
                .createReportEvent(this.getClass(), actor.getName(),"try to control and accidentally scratched " + subject.getClass().getSimpleName() + " " + subject.getName())
                .execute();
    }
}
