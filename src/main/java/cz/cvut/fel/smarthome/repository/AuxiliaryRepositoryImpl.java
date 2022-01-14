package cz.cvut.fel.smarthome.repository;

import com.google.gson.Gson;
import cz.cvut.fel.smarthome.model.auxiliary.Auxiliary;
import cz.cvut.fel.smarthome.model.auxiliary.AuxiliaryType;
import cz.cvut.fel.smarthome.model.auxiliary.state.AvailableAuxiliaryState;
import cz.cvut.fel.smarthome.repository.interfaces.AuxiliaryRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class AuxiliaryRepositoryImpl extends AbstractJSONRepo<String, Auxiliary> implements AuxiliaryRepository {

    public AuxiliaryRepositoryImpl() throws FileNotFoundException {
        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/auxiliary/1.json"));
        pool = new HashSet<Auxiliary>(gson.fromJson(br, Collection.class));
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
