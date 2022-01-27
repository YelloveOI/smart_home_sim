package cz.cvut.fel.smarthome.controller.basic;

import cz.cvut.fel.smarthome.model.service.LocationService;
import cz.cvut.fel.smarthome.model.service.UsableDeviceService;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;
import javassist.NotFoundException;

public class LocationController {

    @Inject
    private LocationService locationService;
    @Inject
    private UsableDeviceService usableDeviceService;

    public String getUsableDeviceLocationName(String houseID, String usableDeviceID) {
        try {
            return locationService.getLocationName(houseID, usableDeviceService.getDevice(usableDeviceID));
        } catch (NotFoundException e) {
            System.out.println(e);
        }

        return "NOT_FOUND";
    }

}
