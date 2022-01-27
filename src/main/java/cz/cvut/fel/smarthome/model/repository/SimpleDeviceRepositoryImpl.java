package cz.cvut.fel.smarthome.model.repository;

import cz.cvut.fel.smarthome.model.entities.device.AbstractSimpleDevice;
import cz.cvut.fel.smarthome.model.repository.interfaces.SimpleDeviceRepository;

import java.util.Set;
import java.util.stream.Collectors;

public class SimpleDeviceRepositoryImpl extends AbstractContextRepo<String, AbstractSimpleDevice> implements SimpleDeviceRepository {

    @Override
    public Set<AbstractSimpleDevice> findAllByPredicate(String predicate) {
        return pool.stream()
                .filter(v -> v.getId().contains(predicate))
                .collect(Collectors.toSet());
    }
}
