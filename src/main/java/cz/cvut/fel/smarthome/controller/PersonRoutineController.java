package cz.cvut.fel.smarthome.controller;

import cz.cvut.fel.smarthome.controller.basic.AuxiliaryController;
import cz.cvut.fel.smarthome.controller.basic.LocationController;
import cz.cvut.fel.smarthome.controller.basic.PersonController;
import cz.cvut.fel.smarthome.controller.basic.UsableDeviceController;
import cz.cvut.fel.smarthome.model.service.LocationService;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

public class PersonRoutineController {

    @Inject
    private PersonController personController;
    @Inject
    private AuxiliaryController auxiliaryController;
    @Inject
    private UsableDeviceController usableDeviceController;
    @Inject
    private LocationController locationController;

    public void goWork(String houseID, String personID, String carID) {
        personController.goWork(houseID, personID);
        auxiliaryController.use(houseID, carID);
    }

    public void goSport(String houseID, String personID, String sportInventoryID) {
        personController.goSport(houseID, personID);
        auxiliaryController.stopUse(houseID, sportInventoryID);
    }

    public void goProcrastinate(String houseID, String personID, String usableDeviceID) {
        personController.goProcrastinate(
                houseID,
                personID,
                locationController.getUsableDeviceLocationName(houseID, usableDeviceID)
        );
        usableDeviceController.use(usableDeviceID);
    }

    public void stopDeviceActivity(String houseID, String personID, String usableDeviceID) {
        personController.stopActivity(houseID, personID);
        usableDeviceController.stopUse(usableDeviceID);
    }

    public void stopAuxiliaryActivity(String houseID, String personID, String auxiliaryID) {
        personController.stopActivity(houseID, personID);
        auxiliaryController.stopUse(houseID, auxiliaryID);
    }

}
