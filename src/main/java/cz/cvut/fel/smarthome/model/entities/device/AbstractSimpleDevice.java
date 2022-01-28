package cz.cvut.fel.smarthome.model.entities.device;

import cz.cvut.fel.smarthome.model.entities.State;
import cz.cvut.fel.smarthome.model.entities.basic.AbstractEntity;
import cz.cvut.fel.smarthome.model.entities.Command;
import cz.cvut.fel.smarthome.model.entities.basic.Consumer;
import cz.cvut.fel.smarthome.model.event.Event;

import java.util.Set;

public abstract class AbstractSimpleDevice extends AbstractEntity<String> {

    protected final Consumer consumer;
    protected State currentState;

    public AbstractSimpleDevice(String id, Consumer consumer, State defaultState) {
        super(id);
        this.consumer = consumer;
        this.currentState = defaultState;
    }

    //true = state changed, false = state not changed
    abstract public Boolean command(Command command);

    abstract public <T extends AbstractSimpleDevice> Event<T> getEvent();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("> Device: ")
                .append(id)
                .append("\n\t Current state: ")
                .append(currentState)
                .append("\n\t")
                .append(consumer)
                .append("\n--------------------------------");

        return sb.toString();
    }

}
