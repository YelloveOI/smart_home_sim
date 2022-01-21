package cz.cvut.fel.smarthome.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import cz.cvut.fel.smarthome.model.entities.location.House;
import cz.cvut.fel.smarthome.model.entities.location.Location;
import cz.cvut.fel.smarthome.repository.interfaces.LocationRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

public class LocationRepositoryImpl extends AbstractJSONRepo<String, Location> implements LocationRepository {

    public LocationRepositoryImpl() throws FileNotFoundException {
        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/location/1.json"));
        Type setType = new TypeToken<Set<Location>>() {}.getType();
        pool = new HashSet<Location>(gson.fromJson(br, setType));
    }
}
