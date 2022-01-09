package cz.cvut.fel.smarthome.service.interfaces;

import cz.cvut.fel.smarthome.model.Auxiliary;
import cz.cvut.fel.smarthome.model.device.Device;
import cz.cvut.fel.smarthome.model.enums.DeviceStateType;
import cz.cvut.fel.smarthome.model.location.Location;

public interface IPersonActionService {

    //TODO
    void move(String personID, Location targetLoc);

    void useAuxiliary(String personID, Auxiliary aux);

    void controlDevice(String personID, Device device, DeviceStateType stateNeeded);

    //TODO
    void getDeviceManual(String personID, Device device);

    //TODO

}