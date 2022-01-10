package cz.cvut.fel.smarthome.model.event;

import java.time.LocalDateTime;
import java.util.Date;

public class Scenario extends Event {

    //TODO add actions and processing

    public Scenario(Class senderClass, String senderName, LocalDateTime date, EventChannel channel) {
        super(senderClass, senderName, date, channel);
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
    public void execute() {
        super.execute();
    }

    @Override
    public String toString() {
        return null;
    }
}
