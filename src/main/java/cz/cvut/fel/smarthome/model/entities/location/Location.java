package cz.cvut.fel.smarthome.model.entities.location;

import cz.cvut.fel.smarthome.model.entities.auxiliary.AbstractAuxiliary;
import cz.cvut.fel.smarthome.model.entities.basic.AbstractEntity;
import cz.cvut.fel.smarthome.model.entities.basic.interfaces.ILocateable;
import cz.cvut.fel.smarthome.model.entities.device.AbstractSimpleDevice;
import cz.cvut.fel.smarthome.model.entities.device.AbstractStorageDevice;
import cz.cvut.fel.smarthome.model.entities.device.AbstractUsableDevice;
import cz.cvut.fel.smarthome.model.entities.movable.AbstractAlive;

import java.util.HashSet;
import java.util.Set;

public class Location extends AbstractEntity<String> {

    private final LocationType locationType;
    private final Set<AbstractEntity> entities;

    public Location(String s, LocationType locationType) {
        super(s);
        this.locationType = locationType;
        this.entities = new HashSet<>();
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void addEntity(AbstractEntity entity) {
        entities.add(entity);
    }

    public void removeEntity(AbstractEntity entity) {
        entities.remove(entity);
    }

    public Set<AbstractEntity> getEntities() {
        return entities;
    }

}
