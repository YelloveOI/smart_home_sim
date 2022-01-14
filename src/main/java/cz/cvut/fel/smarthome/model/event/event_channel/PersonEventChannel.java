package cz.cvut.fel.smarthome.model.event.event_channel;

import cz.cvut.fel.smarthome.model.event.Event;

public class PersonEventChannel extends EventChannel {

    public PersonEventChannel(EventChannel nextChannel) {
        super(3, nextChannel);
    }

    @Override
    protected void process(Event e) {

    }
}
