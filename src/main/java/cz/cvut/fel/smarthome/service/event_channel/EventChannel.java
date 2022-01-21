package cz.cvut.fel.smarthome.service.event_channel;

import cz.cvut.fel.smarthome.model.event.Event;

public abstract class EventChannel {

    private final Integer priority;
    private EventChannel nextChannel;

    public EventChannel(Integer priority, EventChannel nextChannel) {
        this.priority = priority;
        this.nextChannel = nextChannel;
    }

    public void setNextChannel(EventChannel nextChannel) {
        this.nextChannel = nextChannel;
    }

    public void notify(Event e) {
        if(e.getPriority() >= priority) {
            Boolean goNext = process(e);
            if(nextChannel != null && goNext) {
                nextChannel.notify(e);
            }
        }
    }

    //true = go ahead, false = stop
    protected abstract Boolean process(Event e);

}
