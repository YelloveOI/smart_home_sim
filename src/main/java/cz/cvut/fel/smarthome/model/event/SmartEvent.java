package cz.cvut.fel.smarthome.model.event;

public class SmartEvent<T> extends Event<T> {

    private final EventType eventType;
    private final String description;

    public SmartEvent(T sender, EventType eventType, String description) {
        super(sender, 2);
        this.eventType = eventType;
        this.description = description;
    }

    public EventType getEventType() {
        return eventType;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        //TODO
        return null;
    }
}
