package cz.cvut.fel.smarthome.model.entities.device;

import cz.cvut.fel.smarthome.model.entities.basic.Consumer;
import cz.cvut.fel.smarthome.model.entities.basic.Locatable;
import cz.cvut.fel.smarthome.model.entities.basic.Storage;
import cz.cvut.fel.smarthome.model.entities.basic.interfaces.IStorage;

import java.util.Set;

public abstract class StorageDevice extends SimpleDevice implements IStorage {

    private final Storage storage;

    public StorageDevice(String id, Set<String> stateSet, Set<Consumer> consumerSet, String defaultState, Locatable locatable, Storage storage) {
        super(id, stateSet, consumerSet, defaultState, locatable);
        this.storage = storage;
    }

    @Override
    public String getData() {
        StringBuilder sb = new StringBuilder();
        sb
                .append(super.getData())
                .append("\n\t")
                .append(storage);
        
        return sb.toString();
    }
}
