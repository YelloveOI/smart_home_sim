package cz.cvut.fel.smarthome.model.entities.device;

import cz.cvut.fel.smarthome.model.entities.basic.Storage;
import cz.cvut.fel.smarthome.model.entities.basic.interfaces.IStorage;

public class StorageDevice extends DeviceOLD implements IStorage {

    private final Storage storage;

    public StorageDevice(String name, Double activeConsumption, String preferredLocation, Integer itemQuantity) {
        super(name, activeConsumption, preferredLocation);
        this.storage = new Storage(itemQuantity);
    }

    @Override
    public Boolean get() {
        return storage.get();
    }

    @Override
    public void put(Integer itemQuantity) {
        storage.put(itemQuantity);
    }

    @Override
    public Boolean isEmpty() {
        return storage.isEmpty();
    }
}
