package cz.cvut.fel.smarthome.model.entities.device;

import cz.cvut.fel.smarthome.model.entities.basic.Consumer;
import cz.cvut.fel.smarthome.model.entities.basic.Locatable;
import cz.cvut.fel.smarthome.model.entities.basic.Storage;
import cz.cvut.fel.smarthome.model.entities.basic.interfaces.IStorage;

import java.util.Set;

//TODO нужен ли вообще storage как basic?
public abstract class AbstractStorageDevice extends AbstractSimpleDevice implements IStorage {

    protected final Storage storage;

    public AbstractStorageDevice(String id, Set<String> stateSet, Consumer consumer, String defaultState, Locatable locatable, Storage storage) {
        super(id, stateSet, consumer, defaultState, locatable);
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
