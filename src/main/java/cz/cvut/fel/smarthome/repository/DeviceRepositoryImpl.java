package cz.cvut.fel.smarthome.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import cz.cvut.fel.smarthome.model.entities.device.abstract_device.state.InactiveDeviceState;
import cz.cvut.fel.smarthome.repository.interfaces.DeviceRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.*;

public class DeviceRepositoryImpl extends AbstractJSONRepo<String, DeviceOLD> implements DeviceRepository {


    public DeviceRepositoryImpl() throws FileNotFoundException {
        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/device/1.json"));
        Type setType = new TypeToken<Set<DeviceOLD>>() {}.getType();
        pool = new HashSet<DeviceOLD>(gson.fromJson(br, setType));
        for(DeviceOLD d : pool) {
            d.setDeviceState(new InactiveDeviceState(d));
        }
    }

//    @Override
//    public Optional<Device> findRandomByIsAvailable() {
//        Random rnd = new Random();
//
//        return pool.stream()
//                .filter(Device::isAvailable)
//                .sorted((v1, v2) -> {
//                    if(v1.equals(v2)) return 0;
//                    return (rnd.nextBoolean()) ? 1 : -1;
//                })
//                .findFirst();
//    }

}
