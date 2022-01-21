package cz.cvut.fel.smarthome.service.event_channel;

import cz.cvut.fel.smarthome.model.event.SmartEvent;
import cz.cvut.fel.smarthome.model.event.Event;

public class PersonEventChannel extends EventChannel {

    public PersonEventChannel(EventChannel nextChannel) {
        super(3, nextChannel);
    }

    @Override
    protected Boolean process(Event e) {
        if(e instanceof SmartEvent) {
            //TODO
        }

        return false;
    }
}
