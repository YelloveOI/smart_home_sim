package cz.cvut.fel.smarthome.model.service;

import cz.cvut.fel.smarthome.model.entities.basic.AbstractEntity;
import cz.cvut.fel.smarthome.model.entities.location.House;
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

    public Boolean allocate(String houseID, AbstractEntity entity, String locationName) throws NotFoundException {
        House house = getHouse(houseID);
        house.deallocate(entity);
        Boolean result = house.allocateEntity(entity, locationName);
        repo.update(house);

        return result;
    }

    public Boolean deallocate(String houseID, AbstractEntity entity) throws NotFoundException {
        House house = getHouse(houseID);
        house.deallocate(entity);
        Boolean result = house.allocateEntity(entity, "OUTSIDE");
        repo.update(house);

        return result;
    }

    public String getLocation(String houseID, AbstractEntity entity) throws NotFoundException {
        return getHouse(houseID).getLocation(entity);
    }

    public Boolean locateBack(String houseID, AbstractEntity entity) throws NotFoundException {
        House house = getHouse(houseID);
        Boolean result = house.locateBack(entity);
        repo.update(house);

        return result;
    }

}
