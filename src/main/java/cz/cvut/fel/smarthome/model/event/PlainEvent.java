package cz.cvut.fel.smarthome.model.event;

import java.util.Date;

public class PlainEvent extends Event {

    private final String description;

    public PlainEvent(Date date, EventChannel channel, String description) {
        super(date, channel);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public Date getDate() {
        return super.getDate();
    }

    @Override
    public void execute() {
        super.execute();
    }

    @Override
    public String toString() {
        return "Plain event, date: " + getDate() + "\n\t description: " + description;
    }
}
