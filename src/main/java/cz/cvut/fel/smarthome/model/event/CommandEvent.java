package cz.cvut.fel.smarthome.model.event;

import cz.cvut.fel.smarthome.model.actor.action.Action;

import java.time.LocalDateTime;

public class CommandEvent extends Event {

    private final Action action;
    private final String actorName;

    public CommandEvent(Class senderClass, String senderName, LocalDateTime date, Action action, String actorName) {
        super(senderClass, senderName, date, 2);
        this.action = action;
        this.actorName = actorName;
    }

    public Action getAction() {
        return action;
    }

    public String getActorName() {
        return actorName;
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
