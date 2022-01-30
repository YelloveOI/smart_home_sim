package cz.cvut.fel.smarthome.model.service;

import cz.cvut.fel.smarthome.model.entities.Command;
import cz.cvut.fel.smarthome.model.entities.device.AbstractSimpleDevice;
import cz.cvut.fel.smarthome.model.entities.device.AbstractStorageDevice;
import cz.cvut.fel.smarthome.model.entities.device.AbstractUsableDevice;
import cz.cvut.fel.smarthome.model.repository.interfaces.SimpleDeviceRepository;
import cz.cvut.fel.smarthome.model.repository.interfaces.StorageDeviceRepository;
import cz.cvut.fel.smarthome.model.repository.interfaces.UsableDeviceRepository;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

import java.util.Collection;
import java.util.Set;

public class SmartService {

    @Inject
    private SimpleDeviceRepository simpleDeviceRepository;
    @Inject
    private StorageDeviceRepository storageDeviceRepository;
    @Inject
    private UsableDeviceRepository usableDeviceRepository;

    public void closeBlinds() {
        Set<AbstractSimpleDevice> devices = simpleDeviceRepository.findAllByPredicate("BLIND_");
        for(AbstractSimpleDevice a : devices) {
            a.command(Command.C_CLOSE);
        }
    }

    public void openBlinds() {
        Set<AbstractSimpleDevice> devices = simpleDeviceRepository.findAllByPredicate("BLIND_");
        for(AbstractSimpleDevice a : devices) {
            a.command(Command.C_OPEN);
        }
    }

    public void turnOnAllSimpleDevices() {
        Collection<AbstractSimpleDevice> devices = simpleDeviceRepository.findAll();
        for(AbstractSimpleDevice a : devices) {
            a.command(Command.C_ON);
        }
    }

    public void turnOffAllSimpleDevices() {
        Collection<AbstractSimpleDevice> devices = simpleDeviceRepository.findAll();
        for(AbstractSimpleDevice a : devices) {
            a.command(Command.C_OFF);
        }
    }

    public void turnOnAllStorageDevices() {
        Collection<AbstractStorageDevice> devices = storageDeviceRepository.findAll();
        for(AbstractStorageDevice a : devices) {
            a.command(Command.C_ON);
        }
    }

    public void turnOffAllStorageDevices() {
        Collection<AbstractStorageDevice> devices = storageDeviceRepository.findAll();
        for(AbstractStorageDevice a : devices) {
            a.command(Command.C_OFF);
        }
    }

    public void turnOnAllUsableDevices() {
        Collection<AbstractUsableDevice> devices = usableDeviceRepository.findAll();
        for(AbstractUsableDevice a : devices) {
            a.command(Command.C_ON);
        }
    }

    public void turnOffAllUsableDevices() {
        Collection<AbstractUsableDevice> devices = usableDeviceRepository.findAll();
        for(AbstractUsableDevice a : usableDeviceRepository.findAll()) {
            a.command(Command.C_OFF);
        }
    }

}
