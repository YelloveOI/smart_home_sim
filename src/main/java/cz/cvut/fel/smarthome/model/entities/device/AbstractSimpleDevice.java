package cz.cvut.fel.smarthome.model.entities.device;

import cz.cvut.fel.smarthome.model.entities.AbstractEntity;
import cz.cvut.fel.smarthome.model.entities.Command;
import cz.cvut.fel.smarthome.model.entities.basic.Consumer;
import cz.cvut.fel.smarthome.model.entities.basic.Locatable;
import cz.cvut.fel.smarthome.model.entities.basic.interfaces.IConsumer;
import cz.cvut.fel.smarthome.model.entities.basic.interfaces.ILocateable;

import java.util.Set;

public abstract class AbstractSimpleDevice extends AbstractEntity<String> {

    //TODO state as class
    protected final Set<String> stateSet;
    protected final Consumer consumer;
    protected final Locatable locatable;
    protected String currentState;

    public AbstractSimpleDevice(String id, Set<String> stateSet, Consumer consumer, String defaultState, Locatable locatable) {
        super(id);
        this.stateSet = stateSet;
        this.consumer = consumer;
        this.currentState = defaultState;
        this.locatable = locatable;
    }

    abstract Boolean command(Command command);

    //TODO data as class
    public String getData() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("> Simple Device: ")
                .append(id)
                .append("\n\t")
                .append(locatable)
                .append("\n\t Current state: ")
                .append(currentState)
                .append("\n\t")
                .append(consumer);

        return sb.toString();
    }
}
