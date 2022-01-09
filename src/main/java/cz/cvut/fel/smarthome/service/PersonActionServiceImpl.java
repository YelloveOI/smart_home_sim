package cz.cvut.fel.smarthome.service;

import cz.cvut.fel.smarthome.model.Person;
import cz.cvut.fel.smarthome.repository.interfaces.CrudRepository;

public class PersonActionServiceImpl {

    private final CrudRepository<String, Person> repo = null;

    public void goWork(String personID) {
        Person person = repo.find(personID);
    }

}
