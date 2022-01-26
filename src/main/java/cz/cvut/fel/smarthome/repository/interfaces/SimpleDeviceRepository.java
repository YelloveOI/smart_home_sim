package cz.cvut.fel.smarthome.repository.interfaces;

import cz.cvut.fel.smarthome.model.entities.device.AbstractSimpleDevice;

import java.util.Set;

public interface SimpleDeviceRepository extends CrudRepository<String, AbstractSimpleDevice> {

    Set<AbstractSimpleDevice> findAllByPredicate(String predicate);

}
