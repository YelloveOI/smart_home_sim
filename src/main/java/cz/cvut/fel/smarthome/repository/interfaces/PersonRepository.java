package cz.cvut.fel.smarthome.repository.interfaces;

import cz.cvut.fel.smarthome.model.entities.person.Person;

import java.util.Optional;

public interface PersonRepository extends CrudRepository<String, Person> {

    Optional<Person> findRandomByIsFree();

}
