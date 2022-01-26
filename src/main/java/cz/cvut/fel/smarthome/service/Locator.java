package cz.cvut.fel.smarthome.service;

import cz.cvut.fel.smarthome.model.entities.location.Location;
import cz.cvut.fel.smarthome.repository.interfaces.LocationRepository;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

import java.util.Optional;


public class Locator {

    @Inject
    private LocationRepository locationRepository;

    public Locator() {
    }

    public void locate(ILocateable locatable) {
        Optional<Location> location = locationRepository.find(locatable.getLocation());
        if(location.isPresent()) {
            location.get().addLocatable(locatable);
            locationRepository.update(location.get());
        }
    }


}
