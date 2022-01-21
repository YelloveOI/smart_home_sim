package cz.cvut.fel.smarthome.service.event_channel;

import cz.cvut.fel.smarthome.model.event.Event;

public class SmartEventChannel extends EventChannel {


    public SmartEventChannel(EventChannel nextChannel) {
        super(2, nextChannel);
    }

    @Override
    protected Boolean process(Event e) {
        return null;
    }
}
