package cz.cvut.fel.smarthome.service.interfaces;

import cz.cvut.fel.smarthome.model.device.Device;
import cz.cvut.fel.smarthome.model.location.Location;

public interface IPetActionService {

    void scratchDevice(String petID, Device targetDevice);

    void move(String petID, Location targetLocation);

}
