package cz.cvut.fel.smarthome.model.location;

import cz.cvut.fel.smarthome.model.AbstractEntity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class House extends AbstractEntity {

    private Integer garagesQuantity;
    private Integer roomsQuantity;
    private Integer embeddedQuantity;
    private Integer floorsQuantity;
    private final Set<Location> locations;

    public House(String name) {
        super(name);
        this.locations = new HashSet<>();
        this.locations.add(new Room("HALL", 0));
        this.locations.add(new Location("OUTSIDE"));
        this.garagesQuantity = 0;
        this.roomsQuantity = 0;
        this.embeddedQuantity = 0;
        this.floorsQuantity = 0;
    }

    public void incGaragesQuantity() {
        garagesQuantity++;
    }

    public void incRoomsQuantity() {
        roomsQuantity++;
    }

    public void incEmbeddedQuantity() {
        embeddedQuantity++;
    }

    public void setFloorsQuantity(Integer floorsQuantity) {
        this.floorsQuantity = floorsQuantity;
    }

    public void addLocation(Location location) {
        locations.add(location);
    }

    public void removeLocation(String name) {
        Optional<Location> temp = locations.stream()
                .filter(v -> v.getName().equals(name))
                .findFirst();
        temp.ifPresent(locations::remove);
    }

    public Set<Location> getLocations() {
        return locations;
    }

    public Boolean checkConfiguration() {
        if(
                !locations.stream()
                        .anyMatch(v -> v.getName().equals("HALL"))
        ) return false;

        if(
                locations.stream()
                        .filter(v -> v instanceof Room)
                        .anyMatch(v -> ((Room) v).getFloorNumber() >= floorsQuantity)
        ) return false;

        if(
                locations.stream()
                        .filter(v -> v instanceof Room)
                        .anyMatch( v -> ((Room) v).getFloorNumber() < 0)
        ) return false;

        if(
                locations.stream()
                        .filter(v -> v instanceof Room)
                        .count() != roomsQuantity
        ) return false;

        if(
                locations.stream()
                        .filter(v -> v instanceof Garage)
                        .count() != garagesQuantity
        ) return false;

        if(
                locations.stream()
                        .filter(v -> v instanceof EmbeddedLocation)
                        .count() != embeddedQuantity
        ) return false;

        return true;
    }

    public Optional<Location> findByName(String name) {
        return locations.stream()
                .filter(v -> Objects.equals(v.getName(), name))
                .findFirst();
    }

    public Outside getOutside() {
        return new Outside();
    }

    //100% works due the constructor
    public Room getHall() {
        return (Room) locations.stream()
                .filter(v -> v.getName().equals("HALL"))
                .findFirst()
                .get();
    }

    
}
