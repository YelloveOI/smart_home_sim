package cz.cvut.fel.smarthome.service;

import cz.cvut.fel.smarthome.model.entities.basic.AbstractEntity;
import cz.cvut.fel.smarthome.repository.interfaces.HouseRepository;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;
import javassist.NotFoundException;

public class Locator {

    //TODO report events
    @Inject
    private HouseRepository houseRepository;

    public void allocate(AbstractEntity entity, String locationName) throws NotFoundException {
        houseRepository.find("SMART_HOUSE").get().deallocate(entity);
        if(!houseRepository.find("SMART_HOUSE").get().allocateEntity(entity, locationName)) {
            throw new NotFoundException("Can't find location: " + locationName);
        }
    }

    public void deallocate(AbstractEntity entity) {
        houseRepository.find("SMART_HOUSE").get().deallocate(entity);
        houseRepository.find("SMART_HOUSE").get().allocateEntity(entity, "OUTSIDE");
    }

    public String getLocation(AbstractEntity entity) {
        return houseRepository.find("SMART_HOUSE").get().getLocation(entity);
    }

    public void locateBack(AbstractEntity entity) throws NotFoundException {
        if(!houseRepository.find("SMART_HOUSE").get().locateBack(entity)) {
            throw new NotFoundException("Can't find preferred location for entity: " + entity.getId());
        }
    }

}
