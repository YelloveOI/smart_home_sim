package cz.cvut.fel.smarthome.model.service;

import cz.cvut.fel.smarthome.model.entities.Command;
import cz.cvut.fel.smarthome.model.entities.State;
import cz.cvut.fel.smarthome.model.entities.device.AbstractUsableDevice;
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

    public Boolean use(String deviceID) throws NotFoundException {
        AbstractUsableDevice device = getDevice(deviceID);
        Boolean result = device.command(Command.C_PLAY);
        repo.update(device);

        return result;
    }

    public Boolean stopUse(String deviceID) throws NotFoundException {
        AbstractUsableDevice device = getDevice(deviceID);
        Boolean result = device.command(Command.C_STOP);
        repo.update(device);

        return result;
    }

    public void repair(String deviceID) throws NotFoundException {
        AbstractUsableDevice device = getDevice(deviceID);
        device.repair();
        repo.update(device);
    }

}
