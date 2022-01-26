package cz.cvut.fel.smarthome.service;

import cz.cvut.fel.smarthome.model.entities.Order;
import cz.cvut.fel.smarthome.model.entities.alive.AbstractAlive;
import cz.cvut.fel.smarthome.repository.interfaces.*;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;
import javassist.NotFoundException;

import java.util.Optional;

public class PersonService {

    @Inject
    private AliveRepository aliveRepository;
    @Inject
    private LocatorService locatorService;

    private AbstractAlive getPerson(String personID) throws NotFoundException {
        Optional<AbstractAlive> person = aliveRepository.find(personID);

        if(person.isEmpty()) {
            throw new NotFoundException("Can't find person with id: " + personID);
        }

        return person.get();
    }

    public Boolean goWork(String personID) throws NotFoundException {
        AbstractAlive person = getPerson(personID);

        locatorService.deallocate(person);
        return person.order(Order.WORK);
    }

    public Boolean goSport(String personID) throws NotFoundException {
        AbstractAlive person = getPerson(personID);

        locatorService.deallocate(person);
        return person.order(Order.SPORT);
    }

    public Boolean goProcrastinate(String personID) throws NotFoundException {
        AbstractAlive person = getPerson(personID);

        return person.order(Order.PROCRASTINATE);
    }

    public void move(String personID, String locationName) throws NotFoundException {
        AbstractAlive person = getPerson(personID);
        locatorService.allocate(person, locationName);
    }

    public void stopActivity(String personID) throws NotFoundException {
        AbstractAlive person = getPerson(personID);
        person.order(Order.GET_FREE);
        locatorService.locateBack(person);
    }

}
