package cz.cvut.fel.smarthome.controller.basic;

import cz.cvut.fel.smarthome.controller.ReportController;
import cz.cvut.fel.smarthome.model.service.SmartService;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

public class SmartController {

    @Inject
    private SmartService smartService;
    @Inject
    private ReportController reportController;

    public void turnOnAllDevice() {
        smartService.turnOnAllSimpleDevices();
        smartService.turnOnAllStorageDevices();
        smartService.turnOnAllUsableDevices();
        reportController.report("SMART HOME turned ON all devices");
    }

    public void turnOffAllDevice() {
        smartService.turnOffAllSimpleDevices();
        smartService.turnOffAllStorageDevices();
        smartService.turnOffAllUsableDevices();
        reportController.report("SMART HOME turned OFF all devices");
    }

    public void openBlinds() {
        smartService.openBlinds();
        reportController.report("SMART HOME opened blinds");
    }

    public void closeBlinds() {
        smartService.closeBlinds();
        reportController.report("SMART HOME closed blinds");
    }

}
