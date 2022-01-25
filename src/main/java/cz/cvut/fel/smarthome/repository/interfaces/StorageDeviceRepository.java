package cz.cvut.fel.smarthome.repository.interfaces;

import cz.cvut.fel.smarthome.model.entities.device.StorageDevice;

import java.util.Optional;

public interface StorageDeviceRepository extends CrudRepository<String, StorageDevice> {

    Optional<StorageDevice> findRandomByStorageDeviceType(StorageDeviceType storageDeviceType);

}
