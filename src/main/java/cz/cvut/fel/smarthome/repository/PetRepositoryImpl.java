package cz.cvut.fel.smarthome.repository;

import com.google.gson.Gson;
import cz.cvut.fel.smarthome.model.actor.person.Person;
import cz.cvut.fel.smarthome.model.actor.person.state.FreePersonState;
import cz.cvut.fel.smarthome.model.actor.pet.Pet;
import cz.cvut.fel.smarthome.repository.interfaces.PetRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class PetRepositoryImpl implements PetRepository {

    private final Set<Pet> petPool;

    public PetRepositoryImpl() throws FileNotFoundException {
        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/pet/1.json"));
        petPool = new HashSet<Pet>(gson.fromJson(br, Collection.class));
        for(Pet p : petPool) {
            //TODO
        }
    }

    @Override
    public Pet create(Pet entity) {
        return null;
    }

    @Override
    public Pet update(Pet entity) {
        return null;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public Pet find(String s) {
        return null;
    }

    @Override
    public Collection<Pet> findAll() {
        return null;
    }
}
