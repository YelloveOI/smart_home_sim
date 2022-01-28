package cz.cvut.fel.smarthome.controller.basic;

import cz.cvut.fel.smarthome.model.service.SmartService;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

public class SmartController {

    @Inject
    private SmartService smartService;

    public void turnOnAllDevice() {
        smartService.turnOnAllSimpleDevices();
        smartService.turnOnAllStorageDevices();
        smartService.turnOnAllUsableDevices();
    }

    public void turnOffAllDevice() {
        smartService.turnOffAllSimpleDevices();
        smartService.turnOffAllStorageDevices();
        smartService.turnOffAllUsableDevices();
    }

    public void openBlinds() {
        smartService.openBlinds();
    }

    public void closeBlinds() {
        smartService.closeBlinds();
    }

}
