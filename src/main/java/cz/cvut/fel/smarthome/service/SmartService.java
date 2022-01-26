package cz.cvut.fel.smarthome.service;

import cz.cvut.fel.smarthome.model.entities.Command;
import cz.cvut.fel.smarthome.model.entities.device.AbstractSimpleDevice;
import cz.cvut.fel.smarthome.repository.interfaces.SimpleDeviceRepository;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

public class SmartService {

    @Inject
    private SimpleDeviceRepository simpleDeviceRepository;

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

}
