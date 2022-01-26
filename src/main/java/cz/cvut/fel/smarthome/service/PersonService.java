package cz.cvut.fel.smarthome.service;

import cz.cvut.fel.smarthome.model.entities.Command;
import cz.cvut.fel.smarthome.model.entities.Order;
import cz.cvut.fel.smarthome.model.entities.auxiliary.AbstractAuxiliary;
import cz.cvut.fel.smarthome.model.entities.device.AbstractUsableDevice;
import cz.cvut.fel.smarthome.model.entities.movable.AbstractAlive;
import cz.cvut.fel.smarthome.model.entities.movable.Person;
import cz.cvut.fel.smarthome.repository.interfaces.*;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;
import javassist.NotFoundException;

import java.util.Optional;

public class PersonService {

    @Inject
    private AliveRepository aliveRepository;
    @Inject
    private Locator locator;

    private AbstractAlive getPerson(String personID) throws NotFoundException {
        Optional<AbstractAlive> person = aliveRepository.find(personID);

        if(person.isEmpty()) {
            throw new NotFoundException("Can't find person with id: " + personID);
        }

        return person.get();
    }

    public Boolean goWork(String personID) throws NotFoundException {
        AbstractAlive person = getPerson(personID);

        locator.deallocate(person);
        return person.order(Order.WORK);
    }

    public Boolean goSport(String personID) throws NotFoundException {
        AbstractAlive person = getPerson(personID);

        locator.deallocate(person);
        return person.order(Order.SPORT);
    }

    public Boolean goProcrastinate(String personID) throws NotFoundException {
        AbstractAlive person = getPerson(personID);

        return person.order(Order.PROCRASTINATE);
    }

    public void move(String personID, String locationName) throws NotFoundException {
        AbstractAlive person = getPerson(personID);
        locator.allocate(person, locationName);
    }

    public void stopActivity(String personID) throws NotFoundException {
        AbstractAlive person = getPerson(personID);
        person.order(Order.GET_FREE);
        locator.locateBack(person);
    }

}
