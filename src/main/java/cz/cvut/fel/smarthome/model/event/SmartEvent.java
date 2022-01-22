package cz.cvut.fel.smarthome.model.event;

import cz.cvut.fel.smarthome.model.entities.AbstractEntity;

public class SmartEvent<T extends AbstractEntity> extends Event<T> {

    public SmartEvent(T sender, EventType eventType) {
        super(sender, 2, eventType);
    }

    @Override
    public String toString() {
        //TODO
        return null;
    }
}
