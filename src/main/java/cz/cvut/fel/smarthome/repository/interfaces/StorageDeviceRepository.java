package cz.cvut.fel.smarthome.repository.interfaces;

import cz.cvut.fel.smarthome.model.entities.device.storage_device.StorageDevice;
import cz.cvut.fel.smarthome.model.entities.device.storage_device.StorageDeviceType;

import java.util.Optional;

public interface StorageDeviceRepository extends CrudRepository<String, StorageDevice> {

    Optional<StorageDevice> findRandomByStorageDeviceType(StorageDeviceType storageDeviceType);

}
