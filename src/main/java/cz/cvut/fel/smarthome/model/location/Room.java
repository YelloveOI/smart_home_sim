package cz.cvut.fel.smarthome.model.location;

public class Room {

    private final String name;
    private final Integer floorNumber;

    public Room(String name, Integer floorNumber) {
        this.name = name;
        this.floorNumber = floorNumber;
    }

    public String getName() {
        return name;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", floorNumber=" + floorNumber +
                '}';
    }
}
