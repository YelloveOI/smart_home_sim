package cz.cvut.fel.smarthome.model.actor.person.state;

import cz.cvut.fel.smarthome.model.actor.person.Person;
import cz.cvut.fel.smarthome.model.actor.action.Action;

public class BusyPersonState extends PersonState {

    public BusyPersonState(Person person) {
        super(person);
    }

    @Override
    public void act(Action action) {
        //TODO ActionReport
    }
}
