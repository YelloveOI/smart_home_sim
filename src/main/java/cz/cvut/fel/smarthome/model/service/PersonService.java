package cz.cvut.fel.smarthome.model.service;

import cz.cvut.fel.smarthome.model.entities.Order;
import cz.cvut.fel.smarthome.model.entities.alive.AbstractAlive;
import cz.cvut.fel.smarthome.model.repository.interfaces.*;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;
import javassist.NotFoundException;

import java.util.Optional;

public class PersonService {

    @Inject
    private AliveRepository repo;

    public AbstractAlive getPerson(String personID) throws NotFoundException {
        Optional<AbstractAlive> person = repo.find(personID);

        if(person.isEmpty()) {
            throw new NotFoundException("Can't find person with id: " + personID);
        }

        return person.get();
    }

    public Boolean goWork(String personID) throws NotFoundException {
        AbstractAlive person = getPerson(personID);
        Boolean result = person.order(Order.O_WORK);
        repo.update(person);

        return result;
    }

    public Boolean goSport(String personID) throws NotFoundException {
        AbstractAlive person = getPerson(personID);
        Boolean result = person.order(Order.O_SPORT);
        repo.update(person);

        return result;
    }

    public Boolean goProcrastinate(String personID) throws NotFoundException {
        AbstractAlive person = getPerson(personID);
        Boolean result = person.order(Order.O_PROCRASTINATE);
        repo.update(person);

        return result;
    }

    public Boolean stopActivity(String personID) throws NotFoundException {
        AbstractAlive person = getPerson(personID);
        Boolean result = person.order(Order.O_GET_FREE);
        repo.update(person);

        return result;
    }

    public Boolean processEvent(String personID) throws NotFoundException {
        AbstractAlive person = getPerson(personID);
        Boolean result = person.order(Order.O_PROCESS_EVENT);
        repo.update(person);

        return result;
    }

}
