package cz.cvut.fel.smarthome.controller;

import cz.cvut.fel.smarthome.model.service.*;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;
import javassist.NotFoundException;

public class PersonController {

    @Inject
    private PersonService personService;
    @Inject
    private LocationService locationService;


    public void goSport(String houseID, String personID) {
        try {
            personService.goSport(personID);
            locationService.deallocate(houseID, personService.getPerson(personID));
        } catch (NotFoundException e) {
            System.out.println(e);
        }
    }

    public void goWork(String houseID, String personID) {
        try {
            personService.goWork(personID);
            locationService.deallocate(houseID, personService.getPerson(personID));
        } catch (NotFoundException e) {
            System.out.println(e);
        }
    }

    public void goProcrastinate(String houseID, String personID, String newLocation) {
        try {
            personService.goSport(personID);
            locationService.allocate(
                    houseID,
                    personService.getPerson(personID),
                    newLocation
            );
        } catch (NotFoundException e) {
            System.out.println(e);
        }
    }

    public void stopActivity(String houseID, String personID) {
        try {
            personService.stopActivity(personID);
            locationService.locateBack(houseID, personService.getPerson(personID));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }

}
