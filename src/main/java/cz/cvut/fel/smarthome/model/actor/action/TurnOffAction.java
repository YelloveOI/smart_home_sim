package cz.cvut.fel.smarthome.model.actor.action;

import cz.cvut.fel.smarthome.model.actor.person.Person;
import cz.cvut.fel.smarthome.model.actor.pet.Pet;
import cz.cvut.fel.smarthome.model.device.Device;
import cz.cvut.fel.smarthome.model.event.EventProcessor;
import cz.cvut.fel.smarthome.model.interfaces.IControl;

public class TurnOffAction extends Action<IControl> {

    public TurnOffAction(Device subject) {
        super(subject);
    }

    @Override
    public void visit(Person actor) {
        subject.turnOff();
        EventProcessor
                .createReport(this.getClass(), actor.getName(),"turning off " + subject.getClass().getSimpleName() + " " + subject.getName())
                .execute();
    }

    @Override
    public void visit(Pet actor) {
        EventProcessor
                .createReport(this.getClass(), actor.getName(),"try to control " + subject.getClass().getSimpleName() + " " + subject.getName())
                .execute();
    }
}
