package cz.cvut.fel.smarthome.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import cz.cvut.fel.smarthome.model.entities.movable.Alive;
import cz.cvut.fel.smarthome.model.entities.movable.state.FreePersonState;
import cz.cvut.fel.smarthome.repository.interfaces.PersonRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

public class PersonRepositoryImpl extends AbstractJSONRepo<String, Alive> implements PersonRepository {

    public PersonRepositoryImpl() throws FileNotFoundException {
        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/person/1.json"));
        Type setType = new TypeToken<Set<Alive>>() {}.getType();
        pool = new HashSet<Alive>(gson.fromJson(br, setType));
        for(Alive p : pool) {
            p.setPersonState(new FreePersonState(p));
        }
    }

    @Override
    public Optional<Alive> findRandomByIsFree() {
        Random rnd = new Random();

        return pool.stream()
                .filter(Alive::isFree)
                .sorted((v1, v2) -> {
                    if(v1.equals(v2)) return 0;
                    return (rnd.nextBoolean()) ? 1 : -1;
                })
                .findFirst();
    }
}
