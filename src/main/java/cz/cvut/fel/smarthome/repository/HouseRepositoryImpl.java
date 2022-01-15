package cz.cvut.fel.smarthome.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import cz.cvut.fel.smarthome.model.device.Device;
import cz.cvut.fel.smarthome.model.location.House;
import cz.cvut.fel.smarthome.repository.interfaces.HouseRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class HouseRepositoryImpl extends AbstractJSONRepo<String, House> implements HouseRepository {

    public HouseRepositoryImpl() throws FileNotFoundException {
        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/house.json"));
        Type setType = new TypeToken<Set<House>>() {}.getType();
        pool = new HashSet<House>(gson.fromJson(br, setType));
    }
}
