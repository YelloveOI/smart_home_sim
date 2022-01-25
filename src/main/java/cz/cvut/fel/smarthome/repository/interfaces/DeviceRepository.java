package cz.cvut.fel.smarthome.repository.interfaces;

import cz.cvut.fel.smarthome.model.entities.device.DeviceOLD;

import java.util.Optional;

public interface DeviceRepository extends CrudRepository<String, DeviceOLD> {

    Optional<DeviceOLD> findRandomByIsAvailable();

}
