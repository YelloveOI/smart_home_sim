package cz.cvut.fel.smarthome.model.actor.state;

import cz.cvut.fel.smarthome.model.actor.Person;
import cz.cvut.fel.smarthome.model.actor.action.Action;

public abstract class PersonState {

    protected final Person person;

    public PersonState(Person person) {
        this.person = person;
    }

    abstract void act(Action action);

}
