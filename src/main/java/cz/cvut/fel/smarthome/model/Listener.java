package cz.cvut.fel.smarthome.model;

import cz.cvut.fel.smarthome.model.event.Event;

public interface Listener {

    void getEvent(Event e);

}
