package cz.cvut.fel.smarthome.service.interfaces;

import cz.cvut.fel.smarthome.model.actor.person.Person;
import cz.cvut.fel.smarthome.model.device.Device;
import cz.cvut.fel.smarthome.model.location.Room;

public interface ILocationService {

    Room getPersonLocation(Person person);

    Room getDeviceLocation(Device device);

}
