package cz.cvut.fel.smarthome.model.actor.person.state;

import cz.cvut.fel.smarthome.model.actor.person.Person;
import cz.cvut.fel.smarthome.model.actor.action.Action;

public class FreePersonState extends PersonState {

    public FreePersonState(Person person) {
        super(person);
    }

    @Override
    public void act(Action action) {
        action.visit(person);
        //TODO ActionReport
    }
}
