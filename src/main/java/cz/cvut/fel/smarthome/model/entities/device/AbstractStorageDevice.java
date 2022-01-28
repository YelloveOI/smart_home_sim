package cz.cvut.fel.smarthome.model.entities.device;

import cz.cvut.fel.smarthome.model.entities.State;
import cz.cvut.fel.smarthome.model.entities.basic.Consumer;
import cz.cvut.fel.smarthome.model.entities.basic.Storage;
import cz.cvut.fel.smarthome.model.entities.basic.interfaces.IStorage;

import java.util.Set;

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
                .append(storage)
                .append("\n--------------------------------");

        return sb.toString();
    }
}
