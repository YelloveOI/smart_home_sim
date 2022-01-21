package cz.cvut.fel.smarthome.model.event;

import java.time.LocalDateTime;

public abstract class Event<T> {

    private final T sender;
    private final LocalDateTime date;
    private final Integer priority;

    public Event(T sender, Integer priority) {
        this.sender = sender;
        this.date = LocalDateTime.now();
        this.priority = priority;
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
