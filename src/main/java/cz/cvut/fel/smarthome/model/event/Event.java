package cz.cvut.fel.smarthome.model.event;

import cz.cvut.fel.smarthome.model.entities.AbstractEntity;

import java.time.LocalDateTime;

public abstract class Event<T extends AbstractEntity> {

    private final T sender;
    private final LocalDateTime date;
    private final Integer priority;
    private final EventType eventType;

    public Event(T sender, Integer priority, EventType eventType) {
        this.sender = sender;
        this.date = LocalDateTime.now();
        this.priority = priority;
        this.eventType = eventType;
    }

    public EventType getEventType() {
        return eventType;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public T getSender() {
        return sender;
    }

    public Integer getPriority() {
        return priority;
    }

    abstract public String toString();

}
