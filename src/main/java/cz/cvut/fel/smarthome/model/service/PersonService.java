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

        repo.update(person);
    }

    public void goSport(String personID) throws NotFoundException, IllegalUseException {
        AbstractAlive person = getPerson(personID);

        repo.update(person);
    }

    public void useDevice(String personID) throws NotFoundException, IllegalUseException {
        AbstractAlive person = getPerson(personID);

        repo.update(person);
    }

    public void stopActivity(String personID) throws NotFoundException, IllegalUseException {
        AbstractAlive person = getPerson(personID);

        repo.update(person);

    }

}
