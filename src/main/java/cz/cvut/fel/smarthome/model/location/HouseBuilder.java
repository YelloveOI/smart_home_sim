package cz.cvut.fel.smarthome.model.location;

import java.util.Optional;

public class HouseBuilder {

    private final House house;

    public HouseBuilder(House house) {
        this.house = house;
    }

    public HouseBuilder(String houseName) {
        this.house = new House(houseName);
    }

    public HouseBuilder addRoom(String name, Integer floorNumber) {
        house.addLocation(new Room(name, floorNumber));
        return this;
    }

    public HouseBuilder removeLocation(String name) {
        house.removeLocation(name);
        return this;
    }

    //city (with chinese accent) code :/
    public HouseBuilder addEmbedded(String name, String roomName) {
        Optional<Location> temp = house.findByName(roomName);
        if(temp.isPresent()) {
            if(temp.get() instanceof Room) {
                ((Room) temp.get()).addEmbedded(new EmbeddedLocation(name, (Room) temp.get()));
            }
        }
        return this;
    }

    public House build() {
        return house;
    }
}
