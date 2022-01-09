package cz.cvut.fel.smarthome.model;

import cz.cvut.fel.smarthome.model.Action;
import cz.cvut.fel.smarthome.model.Event;
import cz.cvut.fel.smarthome.model.Eventer;
import cz.cvut.fel.smarthome.model.Listener;

import java.util.Set;

public class Actor extends Eventer {

    public Actor(Set<Listener> listeners) {
        super(listeners);
    }

    public void notify(Action a) {
        super.notify(a);
    }
}
