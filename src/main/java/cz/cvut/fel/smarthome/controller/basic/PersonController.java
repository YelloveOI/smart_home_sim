package cz.cvut.fel.smarthome.controller.basic;

import cz.cvut.fel.smarthome.controller.EventController;
import cz.cvut.fel.smarthome.model.entities.alive.AbstractAlive;
import cz.cvut.fel.smarthome.model.entities.alive.Person;
import cz.cvut.fel.smarthome.model.event.Event;
import cz.cvut.fel.smarthome.model.event.EventType;
import cz.cvut.fel.smarthome.model.exception.IllegalUseException;
import cz.cvut.fel.smarthome.model.service.LocationService;
import cz.cvut.fel.smarthome.model.service.PersonService;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;
import javassist.NotFoundException;

public class PersonController {

    @Inject
    private PersonService personService;
    @Inject
    private LocationService locationService;
    @Inject
    private EventController eventController;


    public void goSport(String houseID, String personID) {
        try {
            personService.goSport(personID);
            locationService.deallocate(houseID, personService.getPerson(personID));

            eventController.notify(new Event<AbstractAlive>(
                    personService.getPerson(personID),
                    1,
                    EventType.E_NORMAL,
                    personService.getPerson(personID).getId() + " going sport"
            ));
        } catch (NotFoundException e1) {
            System.out.println(e1);
        } catch (IllegalUseException e2) {
            System.out.println(e2);
            e2.printStackTrace();
        }
    }

    public void goWork(String houseID, String personID) {
        try {
            personService.goWork(personID);
            locationService.deallocate(houseID, personService.getPerson(personID));

            eventController.notify(new Event<AbstractAlive>(
                    personService.getPerson(personID),
                    1,
                    EventType.E_NORMAL,
                    personService.getPerson(personID).getId() + " going work"
            ));
        } catch (NotFoundException e1) {
            System.out.println(e1);
        } catch (IllegalUseException e2) {
            System.out.println(e2);
            e2.printStackTrace();
        }
    }

    public void useDevice(String houseID, String personID, String newLocation) {
        try {
            personService.goSport(personID);
            locationService.allocate(
                    houseID,
                    personService.getPerson(personID),
                    newLocation
            );

            eventController.notify(new Event<AbstractAlive>(
                    personService.getPerson(personID),
                    1,
                    EventType.E_NORMAL,
                    personService.getPerson(personID).getId() + " procrastinating"
            ));
        } catch (NotFoundException e1) {
            System.out.println(e1);
        } catch (IllegalUseException e2) {
            System.out.println(e2);
            e2.printStackTrace();
        }
    }

    public void stopActivity(String houseID, String personID) {
        try {
            personService.stopActivity(personID);
            locationService.locateBack(houseID, personService.getPerson(personID));

//            eventController.notify(new Event<AbstractAlive>(
//                    personService.getPerson(personID),
//                    1,
//                    EventType.E_NORMAL,
//                    personService.getPerson(personID).getId() + " getting free"
//            ));
        } catch (NotFoundException e1) {
            System.out.println(e1);
        } catch (IllegalUseException e2) {
            System.out.println(e2);
            e2.printStackTrace();
        }
    }

}
