package cz.cvut.fel.smarthome.repository;

import com.google.gson.Gson;
import cz.cvut.fel.smarthome.model.actor.person.Person;
import cz.cvut.fel.smarthome.model.actor.person.state.FreePersonState;
import cz.cvut.fel.smarthome.model.device.Device;
import cz.cvut.fel.smarthome.model.device.state.InactiveDeviceState;
import cz.cvut.fel.smarthome.repository.interfaces.PersonRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class PersonRepositoryImpl implements PersonRepository {

    private final Set<Person> personPool;

    public PersonRepositoryImpl() throws FileNotFoundException {
        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/person/1.json"));
        personPool = new HashSet<Person>(gson.fromJson(br, Collection.class));
        for(Person p : personPool) {
            p.setPersonState(new FreePersonState(p));
        }
    }

    @Override
    public Person create(Person entity) {
        return null;
    }

    @Override
    public Person update(Person entity) {
        return null;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public Person find(String s) {
        return null;
    }

    @Override
    public Collection<Person> findAll() {
        return null;
    }
}
