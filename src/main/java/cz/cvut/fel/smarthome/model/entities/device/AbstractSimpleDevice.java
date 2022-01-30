package cz.cvut.fel.smarthome.model.entities.device;

import cz.cvut.fel.smarthome.model.entities.State;
import cz.cvut.fel.smarthome.model.basic.AbstractEntity;
import cz.cvut.fel.smarthome.model.entities.Command;
import cz.cvut.fel.smarthome.model.basic.Consumer;

/**
 * Represents smart consumer
 * API implemented via function "command", thus different
 * devices could override this function to it's own behaviour
 */
public abstract class AbstractSimpleDevice extends AbstractEntity<String> {

    protected final Consumer consumer;
    protected State state;

    public AbstractSimpleDevice(String id, Consumer consumer, State defaultState) {
        super(id);
        this.consumer = consumer;
        this.state = defaultState;
    }

    /**
     * Represents device API
     * @param command
     * @return true = state changed, false = state not changed
     */
    abstract public Boolean command(Command command);

    public State getState() {
        return state;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("> Device: ")
                .append(id)
                .append("\n\t Current state: ")
                .append(state)
                .append("\n\t")
                .append(consumer);

        return sb.toString();
    }

}
