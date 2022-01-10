package cz.cvut.fel.smarthome.model.event;

import cz.cvut.fel.smarthome.model.Listener;

import java.util.Date;

public abstract class Event {

    private final Date date;
    private final EventChannel channel;

    public Event(Date date, EventChannel channel) {
        this.date = date;
        this.channel = channel;
    }

    public Date getDate() {
        return date;
    }

    public void execute() {
        channel.get(this);
    }

    abstract public String toString();

}
