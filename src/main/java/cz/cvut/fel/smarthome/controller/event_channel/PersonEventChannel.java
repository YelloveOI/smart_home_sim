package cz.cvut.fel.smarthome.controller.event_channel;

import cz.cvut.fel.smarthome.model.event.Event;

public class PersonEventChannel extends EventChannel {

    public PersonEventChannel() {
        super(2);
    }

    @Override
    protected Boolean process(Event e) {
        return false;
    }
}
