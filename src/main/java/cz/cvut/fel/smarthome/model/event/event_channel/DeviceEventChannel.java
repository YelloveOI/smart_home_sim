package cz.cvut.fel.smarthome.model.event.event_channel;

import cz.cvut.fel.smarthome.model.event.Event;

public class DeviceEventChannel extends EventChannel {


    public DeviceEventChannel(EventChannel nextChannel) {
        super(2, nextChannel);
    }

    @Override
    protected void process(Event e) {

    }
}
