package cz.cvut.fel.smarthome.model.event.event_channel;

import cz.cvut.fel.smarthome.model.event.Event;

public class AchtungEventChannel extends EventChannel {

    public AchtungEventChannel(EventChannel nextChannel) {
        super(4, nextChannel);
    }

    @Override
    protected void process(Event e) {

    }
}
