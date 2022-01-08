package cz.cvut.fel.smarthome.service.interfaces;

import cz.cvut.fel.smarthome.model.location.Location;

public interface ILocationService {
    //TODO
    Location getPersonLocation(String personID);

    Location getPetLocation(String petID);

    Location getDeviceLocation(String deviceID);

    Location getNearestSportAux(String personID);

    Location getNearestWorkAux(String personID);

}
