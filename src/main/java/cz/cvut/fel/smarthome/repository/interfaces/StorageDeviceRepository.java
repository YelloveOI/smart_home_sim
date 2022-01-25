package cz.cvut.fel.smarthome.repository.interfaces;

import cz.cvut.fel.smarthome.model.entities.device.AbstractStorageDevice;

import java.util.Optional;

public interface StorageDeviceRepository extends CrudRepository<String, AbstractStorageDevice> {

    Optional<AbstractStorageDevice> findRandomByStorageDeviceType(StorageDeviceType storageDeviceType);

}
