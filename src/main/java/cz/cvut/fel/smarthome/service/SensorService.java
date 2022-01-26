package cz.cvut.fel.smarthome.service;

import cz.cvut.fel.smarthome.model.entities.Command;
import cz.cvut.fel.smarthome.model.entities.device.AbstractSimpleDevice;
import cz.cvut.fel.smarthome.repository.interfaces.SimpleDeviceRepository;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;
import javassist.NotFoundException;

import java.util.Optional;

public class SensorService {

    @Inject
    private SimpleDeviceRepository simpleDeviceRepository;

    private AbstractSimpleDevice getSensor(String sensorName) throws NotFoundException {
        Optional<AbstractSimpleDevice> sensor = simpleDeviceRepository.find(sensorName);

        if(sensor.isEmpty()) {
            throw new NotFoundException("Can't find sensor: " + sensorName);
        }

        return sensor.get();
    }

    public Boolean trigger(String sensorID) throws NotFoundException {
        AbstractSimpleDevice sensor = getSensor(sensorID);

        return sensor.command(Command.TRIGGER);
    }

}
