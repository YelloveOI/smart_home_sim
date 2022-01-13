package cz.cvut.fel.smarthome.model.location;

import java.util.HashSet;
import java.util.Set;

public class Room extends Location {

    private final Set<EmbeddedLocation> embeddedLocations;

    public Room(String name, Integer floorNumber) {
        super(name, floorNumber);
        this.embeddedLocations = new HashSet<>();
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
}
