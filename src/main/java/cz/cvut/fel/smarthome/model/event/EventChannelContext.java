package cz.cvut.fel.smarthome.model.event;

import cz.cvut.fel.smarthome.model.event.event_channel.*;

public class EventChannelContext {

    private final static EventChannel achtungChannel = new AchtungEventChannel(null);
    private final static EventChannel personChannel = new PersonEventChannel(achtungChannel);
    private final static EventChannel deviceChannel = new DeviceEventChannel(personChannel);
    private final static EventChannel reportChannel = new ReportEventChannel(deviceChannel);

    public static void getEvent(Event e) {
        reportChannel.notify(e);
    }

}
