package cz.cvut.fel.smarthome.controller;

import cz.cvut.fel.smarthome.controller.basic.*;
import cz.cvut.fel.smarthome.model.activity.ActivityType;
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
    @Inject
    private Scheduler scheduler;
    @Inject
    private BusynessController busynessController;

    public void goWork(String houseID, String personID, String carID) {
        personController.goWork(houseID, personID);
        auxiliaryController.use(houseID, carID);
        scheduler.addActivity(personID, carID, ActivityType.A_WORK, 8);
        busynessController.getActivity(personID);
    }

    public void goSport(String houseID, String personID, String sportInventoryID) {
        personController.goSport(houseID, personID);
        auxiliaryController.stopUse(houseID, sportInventoryID);
        scheduler.addActivity(personID, sportInventoryID, ActivityType.A_SPORT, 8);
        busynessController.getActivity(personID);
    }

    public void goProcrastinate(String houseID, String personID, String usableDeviceID) {
        personController.goProcrastinate(
                houseID,
                personID,
                locationController.getUsableDeviceLocationName(houseID, usableDeviceID)
        );
        usableDeviceController.use(usableDeviceID);
        scheduler.addActivity(personID, usableDeviceID, ActivityType.A_PROCRASTINATE, 4);
        busynessController.getActivity(personID);
    }

    public void stopDeviceActivity(String houseID, String personID, String usableDeviceID) {
        personController.stopActivity(houseID, personID);
        usableDeviceController.stopUse(usableDeviceID);
        busynessController.releaseFromActivity(personID);
    }

    public void stopAuxiliaryActivity(String houseID, String personID, String auxiliaryID) {
        personController.stopActivity(houseID, personID);
        auxiliaryController.stopUse(houseID, auxiliaryID);
        busynessController.releaseFromActivity(personID);
    }

}
