package cz.cvut.fel.smarthome.service;

import cz.cvut.fel.smarthome.model.entities.Command;
import cz.cvut.fel.smarthome.model.entities.device.AbstractUsableDevice;
import cz.cvut.fel.smarthome.repository.interfaces.UsableDeviceRepository;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;
import javassist.NotFoundException;

import java.util.Optional;

public class UsableDeviceService {

    @Inject
    private UsableDeviceRepository usableDeviceRepository;
    @Inject
    private Locator locator;

    private AbstractUsableDevice getDevice(String deviceID) throws NotFoundException {
        Optional<AbstractUsableDevice> device = usableDeviceRepository.find(deviceID);

        if(device.isEmpty()) {
            throw new NotFoundException("Can't find device: " + deviceID);
        }
        return device.get();
    }

    public Boolean use(String deviceID) throws NotFoundException {
        AbstractUsableDevice device = getDevice(deviceID);

        return device.command(Command.PLAY);
    }

    public Boolean stopUse(String deviceID) throws NotFoundException {
        AbstractUsableDevice device = getDevice(deviceID);

        return device.command(Command.STOP);
    }

}
