package cz.cvut.fel.smarthome.model.event;

import cz.cvut.fel.smarthome.model.entities.basic.AbstractEntity;

import java.time.LocalDateTime;

public abstract class Event<T extends AbstractEntity<String>> implements Comparable<Event> {

    private final T sender;
    private final LocalDateTime date;
    private final Integer priority;
    private final EventType eventType;
    private final String description;

    public Event(T sender, Integer priority, EventType eventType, String description) {
        this.sender = sender;
        this.description = description;
        this.date = LocalDateTime.now();
        this.priority = priority;
        this.eventType = eventType;
    }

    public String getDescription() {
        return description;
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
