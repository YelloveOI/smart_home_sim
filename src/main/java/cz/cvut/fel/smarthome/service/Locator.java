package cz.cvut.fel.smarthome.service;

import cz.cvut.fel.smarthome.model.entities.AbstractEntity;
import cz.cvut.fel.smarthome.model.entities.person.Person;
import cz.cvut.fel.smarthome.model.entities.pet.Pet;
import cz.cvut.fel.smarthome.model.entities.auxiliary.Auxiliary;
import cz.cvut.fel.smarthome.model.entities.device.Device;
import cz.cvut.fel.smarthome.model.entities.location.House;
import cz.cvut.fel.smarthome.model.entities.location.Location;
import cz.cvut.fel.smarthome.model.interfaces.ILocateable;
import cz.cvut.fel.smarthome.repository.interfaces.HouseRepository;
import cz.cvut.fel.smarthome.repository.interfaces.LocationRepository;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;


public class Locator {

    @Inject
    private LocationRepository locationRepository;

    public Locator() {
    }

    public void locate(ILocateable locateable) {
        Optional<Location> location = locationRepository.find(locateable.getLocation());
        if(location.isPresent()) {
            location.get().addLocateable(locateable);
            locationRepository.update(location.get());
        }
    }

    public void delocate(ILocateable locateable) {
        Optional<Location> location = locationRepository.find(locateable.getLocation());
        if(location.isPresent()) {
            location.get().removeLocateable(locateable);
            locationRepository.update(location.get());
        }
    }

}
