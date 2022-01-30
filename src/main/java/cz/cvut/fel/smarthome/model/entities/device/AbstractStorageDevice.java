package cz.cvut.fel.smarthome.model.entities.device;

import cz.cvut.fel.smarthome.model.entities.State;
import cz.cvut.fel.smarthome.model.basic.Consumer;
import cz.cvut.fel.smarthome.model.basic.Storage;
import cz.cvut.fel.smarthome.model.basic.interfaces.IStorage;

/**
 * Represents device which can store items
 */
public abstract class AbstractStorageDevice extends AbstractSimpleDevice implements IStorage {

    protected final Storage storage;

    public AbstractStorageDevice(String id, Consumer consumer, State defaultState, Storage storage) {
        super("STORAGE_" + id, consumer, defaultState);
        this.storage = storage;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append(super.toString())
                .append("\n\t")
                .append(storage);

        return sb.toString();
    }
}
