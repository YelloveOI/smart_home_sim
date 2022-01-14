package cz.cvut.fel.smarthome.model.event.event_channel;

import cz.cvut.fel.smarthome.model.event.Event;
import cz.cvut.fel.smarthome.model.event.event_channel.EventChannel;

public class ReportEventChannel extends EventChannel {

    public ReportEventChannel(EventChannel nextChannel) {
        super(1, nextChannel);
    }

    @Override
    protected void process(Event e) {
        System.out.println(e);
    }
}
