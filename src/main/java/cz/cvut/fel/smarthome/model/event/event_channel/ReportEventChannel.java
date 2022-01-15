package cz.cvut.fel.smarthome.model.event.event_channel;

import cz.cvut.fel.smarthome.model.event.Event;
import cz.cvut.fel.smarthome.model.event.event_channel.EventChannel;

public class ReportEventChannel extends EventChannel {

    public ReportEventChannel(EventChannel nextChannel) {
        super(1, nextChannel);
    }

    @Override
    protected Boolean process(Event e) {
        //TODO запись в файл
        System.out.println(e);
        return true;
    }
}
