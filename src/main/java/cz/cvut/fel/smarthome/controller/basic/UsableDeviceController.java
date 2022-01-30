package cz.cvut.fel.smarthome.controller.basic;

import cz.cvut.fel.smarthome.Reporter;
import cz.cvut.fel.smarthome.model.exception.IllegalUseException;
import cz.cvut.fel.smarthome.model.service.UsableDeviceService;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;
import javassist.NotFoundException;

public class UsableDeviceController {

    @Inject
    private UsableDeviceService usableDeviceService;
    @Inject
    private Reporter reporter;

    public void use(String deviceID) {
        try {
            usableDeviceService.use(deviceID);
            reporter.report("Device " + deviceID + " now in use");
        } catch (NotFoundException e1) {
            System.out.println(e1);
        } catch (IllegalUseException e2) {
            System.out.println(e2);
            e2.printStackTrace();
        }

    }

    public void stopUse(String deviceID) {
        try {
            usableDeviceService.stopUse(deviceID);
            reporter.report("Device " + deviceID + " now in available to use");
        } catch (NotFoundException e1) {
            System.out.println(e1);
        } catch (IllegalUseException e2) {
            System.out.println(e2);
            e2.getStackTrace();
        }
    }

    public void repair(String deviceID) {
        try {
            usableDeviceService.repair(deviceID);
            reporter.report("Device " + deviceID + " repaired");
        } catch (NotFoundException e) {
            System.out.println(e);
        }
    }

}
