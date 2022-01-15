package cz.cvut.fel.smarthome.repository;

import com.google.gson.Gson;
import cz.cvut.fel.smarthome.model.device.Device;
import cz.cvut.fel.smarthome.model.location.House;
import cz.cvut.fel.smarthome.repository.interfaces.HouseRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashSet;

public class HouseRepositoryImpl extends AbstractJSONRepo<String, House> implements HouseRepository {

    public HouseRepositoryImpl() throws FileNotFoundException {
        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/house.json"));
        pool = new HashSet<House>(gson.fromJson(br, Collection.class));
    }
}
