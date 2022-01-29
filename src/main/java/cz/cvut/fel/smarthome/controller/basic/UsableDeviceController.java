package cz.cvut.fel.smarthome.controller.basic;

import cz.cvut.fel.smarthome.controller.EventController;
import cz.cvut.fel.smarthome.model.entities.device.AbstractStorageDevice;
import cz.cvut.fel.smarthome.model.entities.device.AbstractUsableDevice;
import cz.cvut.fel.smarthome.model.event.Event;
import cz.cvut.fel.smarthome.model.event.EventType;
import cz.cvut.fel.smarthome.model.exception.IllegalUseException;
import cz.cvut.fel.smarthome.model.service.UsableDeviceService;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;
import javassist.NotFoundException;

public class UsableDeviceController {

    @Inject
    private UsableDeviceService usableDeviceService;
    @Inject
    private EventController eventController;

    public void use(String deviceID) {
        try {
            usableDeviceService.use(deviceID);
            eventController.notify(new Event<AbstractUsableDevice>(
                    usableDeviceService.getDevice(deviceID),
                    1,
                    EventType.E_NORMAL,
                    usableDeviceService.getDevice(deviceID).getId() + " now in use"
            ));
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
//            eventController.notify(new Event<AbstractUsableDevice>(
//                    usableDeviceService.getDevice(deviceID),
//                    1,
//                    EventType.E_NORMAL,
//                    usableDeviceService.getDevice(deviceID).getId() + " now free"
//            ));
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
