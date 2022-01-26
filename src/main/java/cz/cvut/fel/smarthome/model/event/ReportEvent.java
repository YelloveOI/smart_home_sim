package cz.cvut.fel.smarthome.model.event;

import cz.cvut.fel.smarthome.model.entities.basic.AbstractEntity;

public class ReportEvent<T extends AbstractEntity> extends Event<T> {

    public ReportEvent(T sender, EventType eventType, String description) {
        super(sender, 1, eventType, description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb
                .append("REPORT:\t sender ")
                .append(getSender().getId())
                .append(" of class ")
                .append(getSender().getClass().getSimpleName())
                .append(" reports: ")
                .append(getDescription())
                .append("\n")
                .toString();
    }
}
