package cz.cvut.fel.smarthome.model.event.event_channel;

import cz.cvut.fel.smarthome.model.event.CommandEvent;
import cz.cvut.fel.smarthome.model.event.Event;

public class ActorEventChannel extends EventChannel {

    public ActorEventChannel(EventChannel nextChannel) {
        super(2, nextChannel);
    }

    @Override
    protected Boolean process(Event e) {
        if(e instanceof CommandEvent) {
            //TODO
        }

        return false;
    }
}
