package cz.cvut.fel.smarthome.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import cz.cvut.fel.smarthome.model.entities.device.DeviceOLD;
import cz.cvut.fel.smarthome.model.entities.device.abstract_device.state.InactiveDeviceState;
import cz.cvut.fel.smarthome.model.entities.device.StorageDevice;
import cz.cvut.fel.smarthome.repository.interfaces.StorageDeviceRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

public class StorageDeviceRepositoryImpl extends AbstractJSONRepo<String, StorageDevice> implements StorageDeviceRepository {

    public StorageDeviceRepositoryImpl() throws FileNotFoundException {
        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/storage_device/1.json"));
        Type setType = new TypeToken<Set<StorageDevice>>() {}.getType();
        pool = new HashSet<StorageDevice>(gson.fromJson(br, setType));
        for(DeviceOLD d : pool) {
            d.setDeviceState(new InactiveDeviceState(d));
        }
    }

    @Override
    public Optional<StorageDevice> findRandomByStorageDeviceType(StorageDeviceType storageDeviceType) {
        Random rnd = new Random();

        return pool.stream()
                .filter(v -> v.getStorageDeviceType().equals(storageDeviceType))
                .sorted((v1, v2) -> {
                    if(v1.equals(v2)) return 0;
                    return (rnd.nextBoolean()) ? 1 : -1;
                })
                .findFirst();
    }
}
