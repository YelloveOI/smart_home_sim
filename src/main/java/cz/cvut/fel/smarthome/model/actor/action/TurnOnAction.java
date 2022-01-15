package cz.cvut.fel.smarthome.model.actor.action;

import cz.cvut.fel.smarthome.model.actor.person.Person;
import cz.cvut.fel.smarthome.model.actor.pet.Pet;
import cz.cvut.fel.smarthome.model.device.Device;
import cz.cvut.fel.smarthome.model.event.EventProcessor;

public class TurnOnAction extends Action<Device> {

    public TurnOnAction(Device subject) {
        super(subject);
    }

    @Override
    public void visit(Person actor) {
        subject.turnOn();
//        EventProcessor
//                .createReport(this.getClass(), actor.getName(),"turning on " + subject.getClass().getSimpleName() + " " + subject.getName())
//                .execute();
    }

    @Override
    public void visit(Pet actor) {
        subject.wearOut();
//        EventProcessor
//                .createReport(this.getClass(), actor.getName(),"try to control and accidentally scratched " + subject.getClass().getSimpleName() + " " + subject.getName())
//                .execute();
    }
}
