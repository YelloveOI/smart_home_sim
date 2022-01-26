package cz.cvut.fel.smarthome.service;

import cz.cvut.fel.smarthome.model.entities.Command;
import cz.cvut.fel.smarthome.model.entities.device.AbstractSimpleDevice;
import cz.cvut.fel.smarthome.model.entities.device.AbstractStorageDevice;
import cz.cvut.fel.smarthome.model.entities.device.AbstractUsableDevice;
import cz.cvut.fel.smarthome.repository.interfaces.SimpleDeviceRepository;
import cz.cvut.fel.smarthome.repository.interfaces.StorageDeviceRepository;
import cz.cvut.fel.smarthome.repository.interfaces.UsableDeviceRepository;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

public class SmartService {

    @Inject
    private SimpleDeviceRepository simpleDeviceRepository;
    @Inject
    private StorageDeviceRepository storageDeviceRepository;
    @Inject
    private UsableDeviceRepository usableDeviceRepository;

    public void closeBlinds() {
        for(AbstractSimpleDevice a : simpleDeviceRepository.findAllByPredicate("BLIND_")) {
            a.command(Command.CLOSE);
        }
    }

    public void openBlinds() {
        for(AbstractSimpleDevice a : simpleDeviceRepository.findAllByPredicate("BLIND_")) {
            a.command(Command.OPEN);
        }
    }

    public void turnOnAllSimpleDevices() {
        for(AbstractSimpleDevice a : simpleDeviceRepository.findAll()) {
            a.command(Command.ON);
        }
    }

    public void turnOffAllSimpleDevices() {
        for(AbstractSimpleDevice a : simpleDeviceRepository.findAll()) {
            a.command(Command.OFF);
        }
    }

    public void turnOnAllStorageDevices() {
        for(AbstractStorageDevice a : storageDeviceRepository.findAll()) {
            a.command(Command.ON);
        }
    }

    public void turnOffAllStorageDevices() {
        for(AbstractStorageDevice a : storageDeviceRepository.findAll()) {
            a.command(Command.OFF);
        }
    }

    public void turnOnAllUsableDevices() {
        for(AbstractUsableDevice a : usableDeviceRepository.findAll()) {
            a.command(Command.ON);
        }
    }

    public void turnOffAllUsableDevices() {
        for(AbstractUsableDevice a : usableDeviceRepository.findAll()) {
            a.command(Command.OFF);
        }
    }

}
