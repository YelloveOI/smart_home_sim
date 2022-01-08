package cz.cvut.fel.smarthome.repository;

import cz.cvut.fel.smarthome.model.device.Device;

public class DeviceRepository extends AbstractRepository<String, Device> {

    public Device create(Device device) {
        return super.create(device.getName(), device);
    }

    public Device update(Device device) {
        return super.update(device.getName(), device);
    }

}
