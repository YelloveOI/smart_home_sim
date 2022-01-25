package cz.cvut.fel.smarthome.model.entities.person.state;

import cz.cvut.fel.smarthome.model.action.Action;
import cz.cvut.fel.smarthome.model.entities.person.Person;
import cz.cvut.fel.smarthome.model.entities.basic.interfaces.IUsable;

public class FreePersonState extends PersonState {

    public FreePersonState(Person person) {
        super(person);
    }

    @Override
    public void act(Action action) {
        action.visit(person);
    }

    @Override
    public void becomeBusy(IUsable usable) {
        person.setPersonState(new BusyPersonState(person));
        person.setInUse(usable);
    }

    @Override
    public void getFree() {
    }

    @Override
    public Boolean isFree() {
        return true;
    }

}
