package cz.cvut.fel.smarthome.repository.interfaces;

import cz.cvut.fel.smarthome.model.entities.device.Device;

import java.util.Optional;

public interface DeviceRepository extends CrudRepository<String, Device> {

    Optional<Device> findFirstByIsAvailable();

    Optional<Device> findRandom();

    Optional<Device> findFoodStorage();

}
