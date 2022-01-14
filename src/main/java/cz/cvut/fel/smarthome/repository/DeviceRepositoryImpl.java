package cz.cvut.fel.smarthome.repository;

import com.google.gson.Gson;
import cz.cvut.fel.smarthome.model.auxiliary.Auxiliary;
import cz.cvut.fel.smarthome.model.auxiliary.state.AvailableAuxiliaryState;
import cz.cvut.fel.smarthome.model.device.Device;
import cz.cvut.fel.smarthome.model.device.state.InactiveDeviceState;
import cz.cvut.fel.smarthome.repository.interfaces.DeviceRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class DeviceRepositoryImpl implements DeviceRepository {

    private final Set<Device> devicePool;

    public DeviceRepositoryImpl() throws FileNotFoundException {
        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/device/1.json"));
        devicePool = new HashSet<Device>(gson.fromJson(br, Collection.class));
        for(Device d : devicePool) {
            d.setDeviceState(new InactiveDeviceState(d));
        }
    }

    @Override
    public Device create(Device entity) {
        return null;
    }

    @Override
    public Device update(Device entity) {
        return null;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public Optional<Device> find(String s) {
        return null;
    }

    @Override
    public Collection<Device> findAll() {
        return null;
    }
}
