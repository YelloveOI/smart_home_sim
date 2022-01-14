package cz.cvut.fel.smarthome.model.event;

import java.time.LocalDateTime;

public abstract class Event {

    private final Class senderClass;
    private final String senderName;
    private final LocalDateTime date;
    private final Integer priority;

    public Event(Class senderClass, String senderName, LocalDateTime date, Integer priority) {
        this.senderClass = senderClass;
        this.senderName = senderName;
        this.date = date;
        this.priority = priority;
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

    public Integer getPriority() {
        return priority;
    }

    abstract public String toString();

}
