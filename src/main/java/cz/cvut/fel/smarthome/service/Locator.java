package cz.cvut.fel.smarthome.service;

import cz.cvut.fel.smarthome.model.entities.location.Location;
import cz.cvut.fel.smarthome.model.entities.basic.interfaces.ILocateable;
import cz.cvut.fel.smarthome.repository.interfaces.LocationRepository;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

import java.util.Optional;


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
