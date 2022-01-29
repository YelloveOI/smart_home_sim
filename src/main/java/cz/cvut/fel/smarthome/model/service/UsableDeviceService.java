package cz.cvut.fel.smarthome.model.service;

import cz.cvut.fel.smarthome.model.entities.Command;
import cz.cvut.fel.smarthome.model.entities.device.AbstractUsableDevice;
import cz.cvut.fel.smarthome.model.exception.IllegalUseException;
import cz.cvut.fel.smarthome.model.repository.interfaces.UsableDeviceRepository;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;
import javassist.NotFoundException;

import java.util.Optional;

public class UsableDeviceService {

    @Inject
    private UsableDeviceRepository repo;

    public AbstractUsableDevice getDevice(String deviceID) throws NotFoundException {
        Optional<AbstractUsableDevice> device = repo.find(deviceID);

        if(device.isEmpty()) {
            throw new NotFoundException("Can't find device: " + deviceID);
        }
        return device.get();
    }

    public void use(String deviceID) throws NotFoundException, IllegalUseException {
        AbstractUsableDevice device = getDevice(deviceID);


        repo.update(device);
    }

    public void stopUse(String deviceID) throws NotFoundException, IllegalUseException {
        AbstractUsableDevice device = getDevice(deviceID);

        repo.update(device);
    }

    public void repair(String deviceID) throws NotFoundException {
        AbstractUsableDevice device = getDevice(deviceID);
        device.repair();
        repo.update(device);
    }

}
