package cz.cvut.fel.smarthome.model.location;

import java.util.HashSet;
import java.util.Set;

public class House {

    private final String name;
    private final Integer floorQuantity;
    private Set<Room> rooms;

    public House(String name, Integer floorQuantity) {
        this.name = name;
        this.floorQuantity = floorQuantity;
        this.rooms = new HashSet<>();
    }

    public House addRoom(String name, Integer floorNumber, Integer windowsQuantity) {
        Room newRoom = new Room(name, floorNumber);
        for(int i = 0; i < windowsQuantity; i++) {
            rooms.add(new Window("Window"+i, newRoom));
        }
        rooms.add(newRoom);
        return this;
    }

    public House addGarage(String name, Integer windowsQuantity) {
        Garage newGarage = new Garage(name);
        for(int i = 0; i < windowsQuantity; i++) {
            rooms.add(new Window("Window"+i, newGarage));
        }
        rooms.add(newGarage);
        return this;
    }

    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                ", floorQuantity=" + floorQuantity +
                ", rooms=" + rooms +
                '}';
    }
}
