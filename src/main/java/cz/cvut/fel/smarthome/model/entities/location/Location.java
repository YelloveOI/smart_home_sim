package cz.cvut.fel.smarthome.model.entities.location;

import cz.cvut.fel.smarthome.model.entities.AbstractEntity;

public class Location extends AbstractEntity<String> {

    private final LocationType locationType;

    public Location(String s, LocationType locationType) {
        super(s);
        this.locationType = locationType;
    }

    public LocationType getLocationType() {
        return locationType;
    }

}
