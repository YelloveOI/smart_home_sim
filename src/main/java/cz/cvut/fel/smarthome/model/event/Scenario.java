package cz.cvut.fel.smarthome.model.event;

import cz.cvut.fel.smarthome.model.event.event_channel.EventChannel;

import java.time.LocalDateTime;

public class Scenario extends Event {

    //TODO add actions and processing

    public Scenario(Class senderClass, String senderName, LocalDateTime date) {
        super(senderClass, senderName, date, 1);
    }

    @Override
    public LocalDateTime getDate() {
        return super.getDate();
    }

    @Override
    public Class getSenderClass() {
        return super.getSenderClass();
    }

    @Override
    public String getSenderName() {
        return super.getSenderName();
    }

    @Override
    public String toString() {
        return null;
    }
}
