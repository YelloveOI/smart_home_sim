package cz.cvut.fel.smarthome.model.entities.location;

import cz.cvut.fel.smarthome.model.entities.basic.AbstractEntity;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

//TODO
public class House extends AbstractEntity<String> {

    private final Integer roomQuantity;
    private final Integer garageQuantity;
    private final Integer embeddedQuantity;
    private final Map<Location, String> embeddedMap;
    private final Set<Location> locations;

    public House(String name, Integer roomQuantity, Integer garageQuantity, Integer embeddedQuantity, Map<Location, String> embeddedMap, Set<Location> locations) {
        super(name);
        this.roomQuantity = roomQuantity;
        this.garageQuantity = garageQuantity;
        this.embeddedQuantity = embeddedQuantity;
        this.embeddedMap = embeddedMap;
        this.locations = locations;
    }

    public Boolean allocateEntity(AbstractEntity entity, String locationName) {
        if(
                locations.stream()
                        .noneMatch(v -> v.getId().contains(locationName))
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("> House Configuration:")
                .append("\n\t Room quantity: ")
                .append(roomQuantity)
                .append("\n\t Garage quantity: ")
                .append(garageQuantity)
                .append("\n\t Embedded quantity: ")
                .append(embeddedQuantity)
                .append("\n\t Locations: ");
        for(Location l : locations.stream().filter(v -> v.getLocationType() != LocationType.EMBEDDED).collect(Collectors.toSet())) {
            sb.append(l.getId());
        }
        sb.append("\n\t Embedded: ");
        for(Location l : embeddedMap.keySet()) {
            sb
                    .append(l.getId())
                    .append("->")
                    .append(embeddedMap.get(l))
                    .append(" ");
        }

        return sb.toString();
    }
}
