package cz.cvut.fel.smarthome.model.service;

import cz.cvut.fel.smarthome.model.entities.device.AbstractStorageDevice;
import cz.cvut.fel.smarthome.model.exception.IllegalUseException;
import cz.cvut.fel.smarthome.model.repository.interfaces.StorageDeviceRepository;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;
import javassist.NotFoundException;

import java.util.Optional;

public class StorageDeviceService {

    @Inject
    private StorageDeviceRepository repo;

    public AbstractStorageDevice getDevice(String deviceID) throws NotFoundException {
        Optional<AbstractStorageDevice> device = repo.find(deviceID);

        if(device.isEmpty()) {
            throw new NotFoundException("Can't find storage device: " + deviceID);
        }

        return device.get();
    }

    public void get(String deviceID, String itemType) throws NotFoundException, IllegalUseException {
        AbstractStorageDevice device = getDevice(deviceID);

        if(!device.get(itemType)) {
            throw new IllegalUseException("Storage device " + deviceID + " doesn't support item type " + itemType);
        }

        repo.update(device);
    }

    public void put(String deviceID, String itemType, Integer itemQuantity) throws NotFoundException, IllegalUseException {
        AbstractStorageDevice device = getDevice(deviceID);

        if(device.put(itemType, itemQuantity)) {
            throw new IllegalUseException("Storage device " + deviceID + " doesn't support item type " + itemType);
        }

        repo.update(device);
    }

    public Boolean isEmpty(String deviceID) throws NotFoundException {
        AbstractStorageDevice device = getDevice(deviceID);

        return device.isEmpty();
    }

    public Integer getQuantityOf(String deviceID, String itemType) throws NotFoundException {
        AbstractStorageDevice device = getDevice(deviceID);

        return device.getQuantityOf(itemType);
    }

}
