package cz.cvut.fel.smarthome;

import cz.cvut.fel.smarthome.controller.BusynessController;
import cz.cvut.fel.smarthome.controller.basic.*;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

import java.util.*;

public class Simulator {

    @Inject
    private BusynessController busynessController;
    @Inject
    private Configurator configurator;
    @Inject
    private PersonController personController;
    @Inject
    private UsableDeviceController usableDeviceController;
    @Inject
    private PetController petController;
    @Inject
    private AuxiliaryController auxiliaryController;
    @Inject
    private LocationController locationController;

    private final Map<String, Integer> stopActivityMap;

    private Integer clock;

    public Simulator() {
        this.clock = 0;
        this.stopActivityMap = new HashMap<>();
    }

    public void start(Integer laps) {
        busynessController.takeData();

        Random rnd = new Random();

        for(int i = 0; i < laps; i++) {

            for(String s : busynessController.getFreePersonsID()) {
                Integer personActivity = rnd.nextInt(3);

                if(personActivity == 0) {
                    Optional<String> carID = busynessController.getFreeCarsID().stream().findAny();
                    if(carID.isPresent()) {
                        auxiliaryController.use(configurator.getHouseName(), carID.get());
                        personController.goWork(configurator.getHouseName(), s);
                        busynessController.getActivity(s);
                        busynessController.getActivity(carID.get());
                        stopActivityMap.put(s, 8 + clock);
                        stopActivityMap.put(carID.get(), 8 + clock);
                    }
                }

                if(personActivity == 1) {
                    Optional<String> sportInventoryID = busynessController.getFreeSportInventoriesID().stream().findAny();
                    if(sportInventoryID.isPresent()) {
                        auxiliaryController.use(configurator.getHouseName(), sportInventoryID.get());
                        personController.goSport(configurator.getHouseName(), s);
                        busynessController.getActivity(s);
                        busynessController.getActivity(sportInventoryID.get());
                        stopActivityMap.put(s, 2 + clock);
                        stopActivityMap.put(sportInventoryID.get(), 2 + clock);
                    }
                }

                if(personActivity == 2) {
                    Optional<String> usableDeviceID = busynessController.getFreeDevicesID().stream().findAny();
                    if(usableDeviceID.isPresent()) {
                        usableDeviceController.use(usableDeviceID.get());
                        personController.useDevice(
                                configurator.getHouseName(),
                                s,
                                locationController.getUsableDeviceLocationName(configurator.getHouseName(), usableDeviceID.get())
                        );
                        busynessController.getActivity(s);
                        busynessController.getActivity(usableDeviceID.get());
                        stopActivityMap.put(s, 2 + clock);
                        stopActivityMap.put(usableDeviceID.get(), 2 + clock);
                    }
                }
            }

            for(String s : stopActivityMap.keySet()) {
                if(Objects.equals(stopActivityMap.get(s), clock)) {

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

            clock++;

        }

    }

}
