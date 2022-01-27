package cz.cvut.fel.smarthome.model.service;

import cz.cvut.fel.smarthome.model.entities.Command;
import cz.cvut.fel.smarthome.model.entities.device.AbstractSimpleDevice;
import cz.cvut.fel.smarthome.model.repository.interfaces.SimpleDeviceRepository;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;
import javassist.NotFoundException;

import java.util.Optional;

public class SensorService {

    @Inject
    private SimpleDeviceRepository repo;

    public AbstractSimpleDevice getSensor(String sensorName) throws NotFoundException {
        Optional<AbstractSimpleDevice> sensor = repo.find(sensorName);

        if(sensor.isEmpty()) {
            throw new NotFoundException("Can't find sensor: " + sensorName);
        }

        return sensor.get();
    }

    public void trigger(String sensorID) throws NotFoundException {
        AbstractSimpleDevice sensor = getSensor(sensorID);

        sensor.command(Command.C_TRIGGER);

        repo.update(sensor);
    }

}
