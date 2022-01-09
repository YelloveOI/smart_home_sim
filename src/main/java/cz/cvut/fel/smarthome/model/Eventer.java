package cz.cvut.fel.smarthome.model;

import java.util.Set;

public class Eventer {

    private final Set<Listener> listeners;

    public Eventer(Set<Listener> listeners) {
        this.listeners = listeners;
    }

    public void subscribeListener(Listener listener) {
        listeners.add(listener);
    }

    public void unsubscribeListener(Listener listener) {
        listeners.remove(listener);
    }

    public void notify(Event e) {
        for(Listener l : listeners) {
            l.getEvent(e);
        }
    }
}
