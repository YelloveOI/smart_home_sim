package cz.cvut.fel.smarthome.model.entities.location;

import cz.cvut.fel.smarthome.model.entities.auxiliary.Car;
import cz.cvut.fel.smarthome.model.entities.basic.AbstractEntity;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class House extends AbstractEntity<String> {

    private final Integer roomQuantity;
    private final Integer garageQuantity;
    private final Integer embeddedQuantity;
    private final Map<Location, String> embeddedMap;
    private final Set<Location> locations;
    private final Map<AbstractEntity, String> preferredLocations;

    public House(
            String name,
            Integer roomQuantity,
            Integer garageQuantity,
            Integer embeddedQuantity,
            Map<Location, String> embeddedMap,
            Set<Location> locations,
            Map<AbstractEntity, String> preferredLocations
    ) {
        super(name);
        this.roomQuantity = roomQuantity;
        this.garageQuantity = garageQuantity;
        this.embeddedQuantity = embeddedQuantity;
        this.embeddedMap = embeddedMap;
        this.locations = locations;
        this.preferredLocations = preferredLocations;
    }

    public Boolean locateBack(AbstractEntity entity) {
        if(!preferredLocations.containsKey(entity)) {
            return false;
        }

        deallocate(entity);
        allocateEntity(entity, preferredLocations.get(entity));

        return true;
    }

    public Boolean allocateEntity(AbstractEntity entity, String locationName) {
        if(
                locations.stream()
                        .noneMatch(v -> v.getId().contains(locationName))
        ) {
            return false;
        }

        if(
                entity instanceof Car && locations.stream()
                        .filter(v -> v.getId().contains(locationName))
                        .findAny().get().getLocationType() != LocationType.GARAGE
        ) {
            return false;
        }

        locations.stream()
                .filter(v -> v.getId().contains(locationName))
                .findAny().get().addEntity(entity);

        return true;
    }

    public void deallocate(AbstractEntity entity) {
        locations.stream()
                .filter(v -> v.getEntities().contains(entity))
                .findAny().ifPresent(v -> v.removeEntity(entity));
    }

    public String getLocation(AbstractEntity entity) {
        String result = locations.stream()
                .filter(v -> v.getEntities().contains(entity))
                .findAny().get().getId();
        return result.substring(result.indexOf("_") + 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("> House Configuration:")
                .append("\n\t House name: ")
                .append(getId())
                .append("\n\t Room quantity: ")
                .append(roomQuantity)
                .append("\n\t Garage quantity: ")
                .append(garageQuantity)
                .append("\n\t Embedded quantity: ")
                .append(embeddedQuantity)
                .append("\n\t Locations: ");
        for(Location l : locations.stream().filter(v -> v.getLocationType() != LocationType.EMBEDDED).collect(Collectors.toSet())) {
            sb
                    .append(l.getId())
                    .append("\t");
        }
        sb.append("\n\t Embedded: ");
        for(Location l : embeddedMap.keySet()) {
            sb
                    .append(l.getId())
                    .append("->")
                    .append(embeddedMap.get(l))
                    .append("\t");
        }

        return sb.toString();
    }
}
