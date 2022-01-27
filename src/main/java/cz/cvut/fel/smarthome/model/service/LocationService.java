package cz.cvut.fel.smarthome.model.service;

import cz.cvut.fel.smarthome.model.entities.basic.AbstractEntity;
import cz.cvut.fel.smarthome.model.entities.location.House;
import cz.cvut.fel.smarthome.model.exception.IllegalUseException;
import cz.cvut.fel.smarthome.model.repository.interfaces.HouseRepository;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;
import javassist.NotFoundException;

import java.util.Optional;

public class LocationService {

    @Inject
    private HouseRepository repo;
    @Inject
    private PersonService personService;
    @Inject
    private AuxiliaryService auxiliaryService;
    @Inject
    private UsableDeviceService usableDeviceService;

    public House getHouse(String houseId) throws NotFoundException {
        Optional<House> house = repo.find(houseId);

        if(house.isEmpty()) {
            throw new NotFoundException("Can't find house: " + houseId);
        }

        return house.get();
    }

    public void allocate(String houseID, AbstractEntity entity, String locationName) throws NotFoundException, IllegalUseException {
        House house = getHouse(houseID);
        house.deallocate(entity);

        if(!house.allocateEntity(entity, locationName)) {
            throw new IllegalUseException("Location " + locationName + " does not exist");
        }

        repo.update(house);
    }

    public void deallocate(String houseID, AbstractEntity entity) throws NotFoundException {
        House house = getHouse(houseID);
        house.deallocate(entity);

        if(!house.allocateEntity(entity, "OUTSIDE")) {
            throw new IllegalUseException("Location OUTSIDE does not exist");
        }

        repo.update(house);
    }

    public String getLocationName(String houseID, AbstractEntity entity) throws NotFoundException {
        return getHouse(houseID).getLocation(entity);
    }

    public void locateBack(String houseID, AbstractEntity entity) throws NotFoundException, IllegalUseException {
        House house = getHouse(houseID);

        if(!house.locateBack(entity)) {
            throw new IllegalUseException("Entity " + entity.getId() + " don't have preferred location");
        }

        repo.update(house);
    }

}
