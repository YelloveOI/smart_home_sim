package cz.cvut.fel.smarthome.controller.basic;

import cz.cvut.fel.smarthome.Reporter;
import cz.cvut.fel.smarthome.model.service.SmartService;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

public class SmartController {

    @Inject
    private SmartService smartService;
    @Inject
    private Reporter reporter;

    public void turnOnAllDevice() {
        smartService.turnOnAllSimpleDevices();
        smartService.turnOnAllStorageDevices();
        smartService.turnOnAllUsableDevices();
        reporter.report("SMART HOME turned ON all devices");
    }

    public void turnOffAllDevice() {
        smartService.turnOffAllSimpleDevices();
        smartService.turnOffAllStorageDevices();
        smartService.turnOffAllUsableDevices();
        reporter.report("SMART HOME turned OFF all devices");
    }

    public void openBlinds() {
        smartService.openBlinds();
        reporter.report("SMART HOME opened blinds");
    }

    public void closeBlinds() {
        smartService.closeBlinds();
        reporter.report("SMART HOME closed blinds");
    }

}
