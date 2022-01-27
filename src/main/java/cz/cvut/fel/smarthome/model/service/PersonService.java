package cz.cvut.fel.smarthome.model.service;

import cz.cvut.fel.smarthome.model.entities.Order;
import cz.cvut.fel.smarthome.model.entities.alive.AbstractAlive;
import cz.cvut.fel.smarthome.model.exception.IllegalUseException;
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

    public void goWork(String personID) throws NotFoundException, IllegalUseException {
        AbstractAlive person = getPerson(personID);

        if(!person.order(Order.O_WORK)) {
            throw new IllegalUseException("Person " + personID + "is busy");
        }

        repo.update(person);
    }

    public void goSport(String personID) throws NotFoundException, IllegalUseException {
        AbstractAlive person = getPerson(personID);

        if(!person.order(Order.O_SPORT)) {
            throw new IllegalUseException("Person " + personID + "is busy");
        }

        repo.update(person);
    }

    public void goProcrastinate(String personID) throws NotFoundException, IllegalUseException {
        AbstractAlive person = getPerson(personID);

       if(!person.order(Order.O_PROCRASTINATE)) {
           throw new IllegalUseException("Person " + personID + "is busy");
       }

        repo.update(person);
    }

    public void stopActivity(String personID) throws NotFoundException, IllegalUseException {
        AbstractAlive person = getPerson(personID);

        if(!person.order(Order.O_GET_FREE)) {
            throw new IllegalUseException("Algorithm error");
        }

        repo.update(person);

    }

    public void processEvent(String personID) throws NotFoundException, IllegalUseException {
        AbstractAlive person = getPerson(personID);

        if(!person.order(Order.O_PROCESS_EVENT)) {
            throw new IllegalUseException("Person " + personID + "is busy");
        }

        repo.update(person);
    }

}
