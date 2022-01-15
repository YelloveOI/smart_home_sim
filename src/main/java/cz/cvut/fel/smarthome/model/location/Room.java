package cz.cvut.fel.smarthome.model.location;

import java.util.HashSet;
import java.util.Set;

public class Room extends Location {

    private final Integer floorNumber;

    public Room(String name, Integer floorNumber) {
        super(name);
        this.floorNumber = floorNumber;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }
}
