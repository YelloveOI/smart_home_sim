package cz.cvut.fel.smarthome.controller;

import cz.cvut.fel.smarthome.controller.basic.AuxiliaryController;
import cz.cvut.fel.smarthome.controller.basic.PersonController;
import cz.cvut.fel.smarthome.controller.basic.PetController;
import cz.cvut.fel.smarthome.controller.basic.UsableDeviceController;
import cz.cvut.fel.smarthome.model.activity.Activity;
import cz.cvut.fel.smarthome.model.activity.ActivityType;
import cz.cvut.fel.smarthome.model.service.UsableDeviceService;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Scheduler {

    @Inject
    private AuxiliaryController auxiliaryController;
    @Inject
    private UsableDeviceController usableDeviceController;
    @Inject
    private PetController petController;
    @Inject
    private PersonController personController;

    private Set<Activity> activities;
    private Integer clock;

    public Scheduler() {
        this.activities = new HashSet<>();
        this.clock = 0;
    }

    private Set<Activity> getCompletedActivities() {
        return activities.stream()
                .filter(v -> v.endTime() <= clock)
                .collect(Collectors.toSet());
    }

    private void getFree(String houseID, String entityID) {
        String predicate = entityID.substring(0, entityID.indexOf("_"));

        switch(predicate) {
            case "CAR_", "SPORT_" -> {
                auxiliaryController.stopUse(houseID, entityID);
            }
            case "PERSON_" -> {
                personController.stopActivity(houseID, entityID);
            }
            case "PET_" -> {
                petController.stopActivity(houseID, entityID);
            }
        }
    }

    public void addActivity(String activeObject, String activitySubject, ActivityType activityType, Integer duration) {
        activities.add(new Activity(activeObject, activitySubject, activityType, clock + duration));
    }

    public void iterate(String houseID) {
        clock++;

        for(Activity a : getCompletedActivities()) {
            getFree(houseID, a.activeObject());
            getFree(houseID, a.activitySubject());
        }
    }

}
