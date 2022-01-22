package cz.cvut.fel.smarthome.model.event;

import cz.cvut.fel.smarthome.model.entities.AbstractEntity;

public class ReportEvent<T extends AbstractEntity> extends Event<T> {

    public ReportEvent(T sender, EventType eventType) {
        super(sender, 1, eventType);
    }

    @Override
    public String toString() {
        //TODO
        return "";
    }
}
