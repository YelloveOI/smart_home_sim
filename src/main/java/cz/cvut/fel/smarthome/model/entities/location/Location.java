package cz.cvut.fel.smarthome.model.entities.location;

import cz.cvut.fel.smarthome.model.entities.AbstractEntity;
import cz.cvut.fel.smarthome.model.interfaces.ILocateable;

import java.util.HashSet;
import java.util.Set;

public class Location extends AbstractEntity<String> {

    private final LocationType locationType;
    private final Set<ILocateable> locateables;

    public Location(String s, LocationType locationType) {
        super(s);
        this.locateables = new HashSet<>();
        this.locationType = locationType;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void addLocateable(ILocateable locateable) {
        locateables.add(locateable);
    }

    public void removeLocateable(ILocateable locateable) {
        locateables.remove(locateable);
    }

    public Set<ILocateable> getLocateables() {
        return locateables;
    }

}
