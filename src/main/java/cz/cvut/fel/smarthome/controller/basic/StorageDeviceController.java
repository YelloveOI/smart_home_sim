package cz.cvut.fel.smarthome.controller.basic;

import cz.cvut.fel.smarthome.controller.EventController;
import cz.cvut.fel.smarthome.model.entities.device.AbstractStorageDevice;
import cz.cvut.fel.smarthome.model.event.Event;
import cz.cvut.fel.smarthome.model.event.EventType;
import cz.cvut.fel.smarthome.model.exception.IllegalUseException;
import cz.cvut.fel.smarthome.model.service.StorageDeviceService;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;
import javassist.NotFoundException;

public class StorageDeviceController {

    @Inject
    private StorageDeviceService storageDeviceService;
    @Inject
    private EventController eventController;

    public void get(String deviceID, String itemType) {
        try {
            storageDeviceService.get(deviceID, itemType);
            eventController.notify(new Event<AbstractStorageDevice>(
                    storageDeviceService.getDevice(deviceID),
                    1,
                    EventType.E_NORMAL,
                    "Decreased number of " + itemType + " in " + storageDeviceService.getDevice(deviceID)
            ));
        } catch (NotFoundException e1) {
            System.out.println(e1);
        } catch (IllegalUseException e2) {
            System.out.println(e2);
            e2.printStackTrace();
        }
    }

    public void put(String deviceID, String itemType, Integer itemQuantity) {
        try {
            storageDeviceService.put(deviceID, itemType, itemQuantity);
            eventController.notify(new Event<AbstractStorageDevice>(
                    storageDeviceService.getDevice(deviceID),
                    1,
                    EventType.E_NORMAL,
                    storageDeviceService.getDevice(deviceID) + " get " + itemQuantity + " of " + itemType
            ));
        } catch (NotFoundException e1) {
            System.out.println(e1);
        } catch (IllegalUseException e2) {
            System.out.println(e2);
            e2.printStackTrace();
        }
    }

    public Boolean isEmpty(String deviceID) {
        try {
            return storageDeviceService.isEmpty(deviceID);
        } catch (NotFoundException e) {
            System.out.println(e);
        }

        return null;
    }

    public Integer getQuantityOf(String deviceID, String itemType) {
        try {
            return storageDeviceService.getQuantityOf(deviceID, itemType);
        } catch (NotFoundException e) {
            System.out.println(e);
        }

        return -1;
    }

}
