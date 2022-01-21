package cz.cvut.fel.smarthome.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import cz.cvut.fel.smarthome.model.entities.auxiliary.Auxiliary;
import cz.cvut.fel.smarthome.model.entities.auxiliary.AuxiliaryType;
import cz.cvut.fel.smarthome.model.entities.auxiliary.state.AvailableAuxiliaryState;
import cz.cvut.fel.smarthome.repository.interfaces.AuxiliaryRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.*;

public class AuxiliaryRepositoryImpl extends AbstractJSONRepo<String, Auxiliary> implements AuxiliaryRepository {

    public AuxiliaryRepositoryImpl() throws FileNotFoundException {
        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/auxiliary/1.json"));
        Type setType = new TypeToken<Set<Auxiliary>>() {}.getType();
        pool = new HashSet<Auxiliary>(gson.fromJson(br, setType));
        for(Auxiliary a : pool) {
            a.setState(new AvailableAuxiliaryState(a));
        }
    }

    @Override
    public Optional<Auxiliary> findFirstByDestinyAndByAvailable(AuxiliaryType type) {
        return pool.stream()
                .filter(v -> v.getDestiny().equals(type))
                .filter(Auxiliary::isAvailable)
                .findFirst();
    }
}
