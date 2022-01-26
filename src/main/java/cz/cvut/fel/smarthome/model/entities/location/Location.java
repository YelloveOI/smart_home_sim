package cz.cvut.fel.smarthome.model.entities.location;

import cz.cvut.fel.smarthome.model.entities.basic.AbstractEntity;
import cz.cvut.fel.smarthome.model.entities.basic.interfaces.ILocateable;

import java.util.HashSet;
import java.util.Set;

public class Location extends AbstractEntity<String> {

    private final LocationType locationType;
    private final Set<ILocateable> locatables;

    public Location(String s, LocationType locationType) {
        super(s);
        this.locatables = new HashSet<>();
        this.locationType = locationType;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void addLocatable(ILocateable locateable) {
        locatables.add(locateable);
    }

    public void removeLocatable(ILocateable locateable) {
        locatables.remove(locateable);
    }

    public Set<ILocateable> getLocatables() {
        return locatables;
    }

}
