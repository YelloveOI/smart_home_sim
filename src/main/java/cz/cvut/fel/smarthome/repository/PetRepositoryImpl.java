package cz.cvut.fel.smarthome.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import cz.cvut.fel.smarthome.model.entities.pet.Pet;
import cz.cvut.fel.smarthome.repository.interfaces.PetRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

public class PetRepositoryImpl extends AbstractJSONRepo<String, Pet> implements PetRepository {

    public PetRepositoryImpl() throws FileNotFoundException {
        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/pet/1.json"));
        Type setType = new TypeToken<Set<Pet>>() {}.getType();
        pool = new HashSet<Pet>(gson.fromJson(br, setType));
        for(Pet p : pool) {
            //TODO
        }
    }

}
