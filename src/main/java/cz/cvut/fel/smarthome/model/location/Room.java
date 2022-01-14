package cz.cvut.fel.smarthome.model.location;

import java.util.HashSet;
import java.util.Set;

public class Room extends Location {

    private final Set<EmbeddedLocation> embeddedLocations;
    private final Integer floorNumber;

    public Room(String name, Integer floorNumber) {
        super(name);
        this.embeddedLocations = new HashSet<>();
        this.floorNumber = floorNumber;
    }

    public void addEmbedded(EmbeddedLocation location) {
        embeddedLocations.add(location);
    }

    public void removeEmbedded(EmbeddedLocation location) {
        embeddedLocations.remove(location);
    }

    public Set<EmbeddedLocation> getEmbeddedLocations() {
        return embeddedLocations;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }
}
