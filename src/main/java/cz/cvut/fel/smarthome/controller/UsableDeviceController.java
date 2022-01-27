package cz.cvut.fel.smarthome.controller;

import cz.cvut.fel.smarthome.model.exception.IllegalUseException;
import cz.cvut.fel.smarthome.model.service.UsableDeviceService;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;
import javassist.NotFoundException;

public class UsableDeviceController {

    @Inject
    private UsableDeviceService usableDeviceService;

    public void use(String deviceID) {
        try {
            usableDeviceService.use(deviceID);
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
        } catch (NotFoundException e) {
            System.out.println(e);
        }
    }

}
