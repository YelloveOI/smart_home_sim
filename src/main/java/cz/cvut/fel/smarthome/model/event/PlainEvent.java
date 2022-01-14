package cz.cvut.fel.smarthome.model.event;

import cz.cvut.fel.smarthome.model.event.event_channel.EventChannel;

import java.time.LocalDateTime;

public class PlainEvent extends Event {

    private final String description;

    public PlainEvent(Class senderClass, String senderName, LocalDateTime date, String description, Integer priority) {
        super(senderClass, senderName, date, priority);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public LocalDateTime getDate() {
        return super.getDate();
    }

    @Override
    public void execute() {
        super.execute();
    }

    @Override
    public String toString() {
        return "Plain event from "+ getSenderClass().getSimpleName() + " " + getSenderName() + " " + ", date: " + getDate() + "\n\t description: " + description;
    }
}
