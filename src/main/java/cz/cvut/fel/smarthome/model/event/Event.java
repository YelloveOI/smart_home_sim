package cz.cvut.fel.smarthome.model.event;

import java.time.LocalDateTime;
import java.util.Date;

public abstract class Event {

    private final Class senderClass;
    private final String senderName;
    private final LocalDateTime date;
    private final EventChannel channel;

    public Event(Class senderClass, String senderName, LocalDateTime date, EventChannel channel) {
        this.senderClass = senderClass;
        this.senderName = senderName;
        this.date = date;
        this.channel = channel;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Class getSenderClass() {
        return senderClass;
    }

    public String getSenderName() {
        return senderName;
    }

    public void execute() {
        channel.get(this);
    }

    abstract public String toString();

}
