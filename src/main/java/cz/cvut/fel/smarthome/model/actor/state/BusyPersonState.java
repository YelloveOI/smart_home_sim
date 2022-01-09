package cz.cvut.fel.smarthome.model.actor.state;

import cz.cvut.fel.smarthome.model.actor.Person;
import cz.cvut.fel.smarthome.model.actor.action.Action;

public class BusyPersonState extends PersonState {

    public BusyPersonState(Person person) {
        super(person);
    }

    @Override
    void act(Action action) {
        //TODO ActionReport
    }
}
