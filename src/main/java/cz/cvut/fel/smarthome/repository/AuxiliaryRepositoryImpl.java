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

public class AuxiliaryRepositoryImpl implements AuxiliaryRepository {

    private final Set<Auxiliary> auxiliaryPool;

    public AuxiliaryRepositoryImpl() throws FileNotFoundException {
        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/auxiliary/1.json"));
        auxiliaryPool = new HashSet<Auxiliary>(gson.fromJson(br, Collection.class));
        for(Auxiliary a : auxiliaryPool) {
            a.setState(new AvailableAuxiliaryState(a));
        }
    }


    @Override
    public Optional<Auxiliary> findFirstByDestinyAndByAvailable(AuxiliaryType type) {
        return Optional.empty();
    }

    @Override
    public Auxiliary create(Auxiliary entity) {
        return null;
    }

    @Override
    public Auxiliary update(Auxiliary entity) {
        return null;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public Auxiliary find(String s) {
        return null;
    }

    @Override
    public Collection<Auxiliary> findAll() {
        return null;
    }
}
