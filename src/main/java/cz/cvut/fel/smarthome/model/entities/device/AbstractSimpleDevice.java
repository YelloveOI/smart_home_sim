package cz.cvut.fel.smarthome.model.entities.device;

import cz.cvut.fel.smarthome.model.entities.basic.AbstractEntity;
import cz.cvut.fel.smarthome.model.entities.Command;
import cz.cvut.fel.smarthome.model.entities.basic.Consumer;

import java.util.Set;

public abstract class AbstractSimpleDevice extends AbstractEntity<String> {

    //TODO state as class
    protected final Set<String> stateSet;
    protected final Consumer consumer;
    protected String currentState;

    public AbstractSimpleDevice(String id, Set<String> stateSet, Consumer consumer, String defaultState) {
        super(id);
        this.stateSet = stateSet;
        this.consumer = consumer;
        this.currentState = defaultState;
    }

    abstract public Boolean command(Command command);

    public String getCurrentState() {
        return currentState;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("> Device: ")
                .append(id)
                .append("\n\t Current state: ")
                .append(currentState)
                .append("\n\t")
                .append(consumer);

        return sb.toString();
    }

}
