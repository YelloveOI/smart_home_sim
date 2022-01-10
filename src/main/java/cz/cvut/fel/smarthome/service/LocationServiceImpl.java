package cz.cvut.fel.smarthome.service;

import cz.cvut.fel.smarthome.model.actor.person.Person;
import cz.cvut.fel.smarthome.model.device.Device;
import cz.cvut.fel.smarthome.model.location.Room;
import cz.cvut.fel.smarthome.service.interfaces.ILocationService;

public class LocationServiceImpl implements ILocationService {

    @Override
    public Room getPersonLocation(Person person) {
        return null;
    }

    @Override
    public Room getDeviceLocation(Device device) {
        return null;
    }
}
