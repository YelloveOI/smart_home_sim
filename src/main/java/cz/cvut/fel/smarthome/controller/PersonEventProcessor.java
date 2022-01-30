package cz.cvut.fel.smarthome.controller;

import cz.cvut.fel.smarthome.controller.basic.SensorController;
import cz.cvut.fel.smarthome.controller.basic.SmartController;
import cz.cvut.fel.smarthome.controller.basic.UsableDeviceController;
import cz.cvut.fel.smarthome.model.service.StorageDeviceService;
import cz.cvut.fel.smarthome.model.service.UsableDeviceService;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

public class PersonEventProcessor {

    @Inject
    private ReportController reportController;
    @Inject
    private SmartController smartController;

    public void turnOnElectricity(String personID) {
        reportController.report("Person " + personID + " now turned ON electricity manually");
        smartController.turnOnAllDevice();
    }

}
