package cz.cvut.fel.smarthome.model.location;

public class Location {

    private final String name;
    private final Integer floorNumber;

    public Location(String name, Integer floorNumber) {
        this.name = name;
        this.floorNumber = floorNumber;
    }

    public String getName() {
        return name;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }
}
