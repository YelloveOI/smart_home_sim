package cz.cvut.fel.smarthome.controller;

import cz.cvut.fel.smarthome.Configurator;
import cz.cvut.fel.smarthome.controller.basic.AuxiliaryController;
import cz.cvut.fel.smarthome.controller.basic.LocationController;
import cz.cvut.fel.smarthome.controller.basic.PersonController;
import cz.cvut.fel.smarthome.controller.basic.UsableDeviceController;
import cz.cvut.fel.smarthome.model.entities.location.Location;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

import java.util.*;

/**
 * Starts random activities for active entities
 */
public class ActivityController {

    @Inject
    private BusynessController busynessController;
    @Inject
    private AuxiliaryController auxiliaryController;
    @Inject
    private PersonController personController;
    @Inject
    private UsableDeviceController usableDeviceController;
    @Inject
    private LocationController locationController;
    @Inject
    private Configurator configurator;

    private final Map<String, Integer> stopActivityMap;

    public ActivityController() {
        this.stopActivityMap = new HashMap<>();
    }

    public void startRandomPersonActivity(String personID, Integer currentTime) {
        Random rnd = new Random();
        Integer personActivityNumber = rnd.nextInt(3);

        if(personActivityNumber == 0) {
            Optional<String> carID = busynessController.getFreeCarsID().stream().findAny();
            if(carID.isPresent()) {
                auxiliaryController.use(configurator.getHouseName(), carID.get());
                personController.goWork(configurator.getHouseName(), personID);
                busynessController.getActivity(personID);
                busynessController.getActivity(carID.get());
                stopActivityMap.put(personID, 8 + currentTime);
                stopActivityMap.put(carID.get(), 8 + currentTime);
            }
        }

        if(personActivityNumber == 1) {
            Optional<String> sportInventoryID = busynessController.getFreeSportInventoriesID().stream().findAny();
            if(sportInventoryID.isPresent()) {
                auxiliaryController.use(configurator.getHouseName(), sportInventoryID.get());
                personController.goSport(configurator.getHouseName(), personID);
                busynessController.getActivity(personID);
                busynessController.getActivity(sportInventoryID.get());
                stopActivityMap.put(personID, 2 + currentTime);
                stopActivityMap.put(sportInventoryID.get(), 2 + currentTime);
            }
        }

        if(personActivityNumber == 2) {
            Optional<String> usableDeviceID = busynessController.getFreeDevicesID().stream().findAny();
            if(usableDeviceID.isPresent()) {
                usableDeviceController.use(usableDeviceID.get());
                personController.useDevice(
                        configurator.getHouseName(),
                        personID,
                        locationController.getUsableDeviceLocationName(configurator.getHouseName(), usableDeviceID.get())
                );
                busynessController.getActivity(personID);
                busynessController.getActivity(usableDeviceID.get());
                stopActivityMap.put(personID, 2 + currentTime);
                stopActivityMap.put(usableDeviceID.get(), 2 + currentTime);
            }
        }
    }

    public void stopAllCompletedActives(Integer currentTime) {
        for(String s : stopActivityMap.keySet()) {
            if(Objects.equals(stopActivityMap.get(s), currentTime)) {

                busynessController.releaseFromActivity(s);

                if(s.contains("PERSON_")) {
                    personController.stopActivity(configurator.getHouseName(), s);
                }
                if(s.contains("PET_")) {
                    //TODO
                }
                if(s.contains("USABLE")) {
                    usableDeviceController.stopUse(s);
                }
                if(s.contains("CAR_") || s.contains("SPORT_")) {
                    auxiliaryController.stopUse(configurator.getHouseName(), s);
                }
            }
        }
    }

}
