package cz.cvut.fel.smarthome.model.event;

import cz.cvut.fel.smarthome.model.event.event_channel.*;

public class EventProcessor {

    private final static EventChannel achtungChannel = new AchtungEventChannel(null);
    private final static EventChannel actorChannel = new ActorEventChannel(achtungChannel);
    private final static EventChannel reportChannel = new ReportEventChannel(actorChannel);

    public static void getEvent(Event e) {
        reportChannel.notify(e);
    }

}
