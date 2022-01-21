package cz.cvut.fel.smarthome.model.entities.person.state;

import cz.cvut.fel.smarthome.model.interfaces.IActive;
import cz.cvut.fel.smarthome.model.interfaces.IActor;
import cz.cvut.fel.smarthome.model.entities.person.Person;
import cz.cvut.fel.smarthome.model.action.Action;
import cz.cvut.fel.smarthome.model.interfaces.IUseable;

public abstract class PersonState implements IActor, IActive {

    protected final Person person;

    public PersonState(Person person) {
        this.person = person;
    }

    public abstract void act(Action action);

    public abstract void becomeBusy(IUseable useable);
    public abstract void getFree();
    public abstract Boolean isFree();
}
