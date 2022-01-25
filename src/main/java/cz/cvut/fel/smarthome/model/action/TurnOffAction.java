package cz.cvut.fel.smarthome.model.action;

import cz.cvut.fel.smarthome.model.entities.movable.Alive;
import cz.cvut.fel.smarthome.model.entities.pet.Pet;

public class TurnOffAction extends Action<IControl> {

    public TurnOffAction(DeviceOLD subject) {
        super(subject);
    }

    @Override
    public void visit(Alive actor) {
        subject.turnOff();
    }

    @Override
    public void visit(Pet actor) {
    }
}
