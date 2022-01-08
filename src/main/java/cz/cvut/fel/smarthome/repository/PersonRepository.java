package cz.cvut.fel.smarthome.repository;

import cz.cvut.fel.smarthome.model.actors.Person;

public class PersonRepository extends AbstractRepository<String, Person> {

    public Person create(Person person) {
        return super.create(person.getName(), person);
    }

    public Person update(Person person) {
        return super.update(person.getName(), person);
    }
}
