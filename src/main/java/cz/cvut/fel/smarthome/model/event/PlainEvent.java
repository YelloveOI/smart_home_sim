package cz.cvut.fel.smarthome.model.event;

import java.time.LocalDateTime;
import java.util.Date;

public class PlainEvent extends Event {

    private final String description;

    public PlainEvent(Class senderClass, String senderName, LocalDateTime date, EventChannel channel, String description) {
        super(senderClass, senderName, date, channel);
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
