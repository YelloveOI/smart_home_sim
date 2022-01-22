package cz.cvut.fel.smarthome.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import cz.cvut.fel.smarthome.model.entities.person.Person;
import cz.cvut.fel.smarthome.model.entities.person.state.FreePersonState;
import cz.cvut.fel.smarthome.repository.interfaces.PersonRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class PersonRepositoryImpl extends AbstractJSONRepo<String, Person> implements PersonRepository {

    public PersonRepositoryImpl() throws FileNotFoundException {
        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/person/1.json"));
        Type setType = new TypeToken<Set<Person>>() {}.getType();
        pool = new HashSet<Person>(gson.fromJson(br, setType));
        for(Person p : pool) {
            p.setPersonState(new FreePersonState(p));
        }
    }

    @Override
    public Optional<Person> findFirstByIsFree() {
        return Optional.empty();
        //TODO
    }
}
