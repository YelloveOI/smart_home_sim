package cz.cvut.fel.smarthome.model.entities.location;

import cz.cvut.fel.smarthome.model.entities.basic.AbstractEntity;
import cz.cvut.fel.smarthome.model.exception.ConfigurationException;

import java.util.*;

public class HouseBuilder {

    private String houseName;
    private Integer roomQuantity;
    private Integer garageQuantity;
    private Integer embeddedQuantity;
    private Set<Location> locations;
    private Map<Location, String> embeddedMap;
    private Map<AbstractEntity, String> preferredLocations;

    public HouseBuilder() {
        this.locations = new HashSet<>();
        this.embeddedMap = new HashMap<>();
        this.preferredLocations = new HashMap<>();
        this.roomQuantity = 0;
        this.garageQuantity = 0;
        this.embeddedQuantity = 0;
        this.houseName = "HOUSE_SMART";
        this.locations.add(new Location("OUTSIDE", LocationType.OUTSIDE));
    }

    public HouseBuilder addPreferredLocation(AbstractEntity entity, String locationName) {
        preferredLocations.put(entity, locationName);
        return this;
    }

    public HouseBuilder setHouseName(String houseName) {
        this.houseName = houseName;
        return this;
    }

    public HouseBuilder addRoom(String name) {
        roomQuantity++;
        locations.add(new Location("ROOM_" + name, LocationType.ROOM));
        return this;
    }

    public HouseBuilder addEmbedded(String name, String installationRoomName) {
        embeddedQuantity++;
        Location embedded = new Location("EMBEDDED_" + name, LocationType.EMBEDDED);
        locations.add(embedded);
        embeddedMap.put(embedded, "ROOM_" + installationRoomName);
        return this;
    }

    public HouseBuilder addGarage(String name) {
        garageQuantity++;
        locations.add(new Location("GARAGE_" + name, LocationType.GARAGE));
        return this;
    }

    public House build() throws ConfigurationException {
        for(String s : embeddedMap.values()) {
            if(
                    locations.stream()
                    .filter(v -> v.getLocationType() == LocationType.ROOM)
                    .map(Location::getId)
                    .noneMatch(v -> Objects.equals(s, v))
            ) {
                throw new ConfigurationException("Bad installation room for some embedded");
            }
        }

        for(String s : preferredLocations.values()) {
            if(
                    locations.stream()
                            .map(Location::getId)
                            .noneMatch(v -> v.contains(s))
            ) {
                throw new ConfigurationException("Bad preferred location for some entity");
            }
        }

        return new House(houseName, roomQuantity, garageQuantity, embeddedQuantity, embeddedMap, locations, preferredLocations);
    }

}
