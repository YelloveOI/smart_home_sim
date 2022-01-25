package cz.cvut.fel.smarthome.repository.interfaces;

import java.util.Optional;

public interface DeviceRepository extends CrudRepository<String, DeviceOLD> {

    Optional<DeviceOLD> findRandomByIsAvailable();

}
