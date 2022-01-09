package cz.cvut.fel.smarthome.model.actor.state;

import cz.cvut.fel.smarthome.model.actor.Person;
import cz.cvut.fel.smarthome.model.actor.action.Action;

public class FreePersonState extends PersonState {

    public FreePersonState(Person person) {
        super(person);
    }

    @Override
    void act(Action action) {
        person.act(action);
        //TODO ActionReport
    }
}
