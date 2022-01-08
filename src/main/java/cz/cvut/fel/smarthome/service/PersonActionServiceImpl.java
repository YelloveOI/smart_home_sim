package cz.cvut.fel.smarthome.service;

import cz.cvut.fel.smarthome.model.Person;
import cz.cvut.fel.smarthome.repository.interfaces.CrudRepository;
import cz.cvut.fel.smarthome.repository.PersonRepository;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

public class PersonActionServiceImpl {

    @Inject(implType = PersonRepository.class)
    private final CrudRepository<String, Person> repo = null;

    public void goWork(String personID) {
        Person person = repo.find(personID);
    }

}
