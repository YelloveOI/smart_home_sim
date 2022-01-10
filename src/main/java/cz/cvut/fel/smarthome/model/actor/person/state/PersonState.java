package cz.cvut.fel.smarthome.model.actor.person.state;

import cz.cvut.fel.smarthome.model.actor.person.Person;
import cz.cvut.fel.smarthome.model.actor.action.Action;

public abstract class PersonState {

    protected final Person person;

    public PersonState(Person person) {
        this.person = person;
    }

    public abstract void act(Action action);

}
