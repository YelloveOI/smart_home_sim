package cz.cvut.fel.smarthome.model.entities.device;

import cz.cvut.fel.smarthome.model.entities.AbstractEntity;
import cz.cvut.fel.smarthome.model.entities.Command;
import cz.cvut.fel.smarthome.model.entities.basic.Consumer;
import cz.cvut.fel.smarthome.model.entities.basic.Locatable;
import cz.cvut.fel.smarthome.model.entities.basic.interfaces.IConsumer;
import cz.cvut.fel.smarthome.model.entities.basic.interfaces.ILocateable;

import java.util.Set;

public abstract class SimpleDevice extends AbstractEntity<String> implements IConsumer, ILocateable {

    //TODO state as class
    private final Set<String> stateSet;
    private final Set<Consumer> consumerSet;
    private final Locatable locatable;
    private String currentState;

    public SimpleDevice(String id, Set<String> stateSet, Set<Consumer> consumerSet, String defaultState, Locatable locatable) {
        super(id);
        this.stateSet = stateSet;
        this.consumerSet = consumerSet;
        this.currentState = defaultState;
        this.locatable = locatable;
    }

    abstract void command(Command command);

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
                .append("\n\t Consumption:");

        for(Consumer c : consumerSet) {
            sb
                    .append("\n\t\t")
                    .append(c);
        }

        return sb.toString();
    }
}
