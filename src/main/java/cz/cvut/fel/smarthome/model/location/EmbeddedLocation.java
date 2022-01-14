package cz.cvut.fel.smarthome.model.location;

import cz.cvut.fel.smarthome.model.device.Device;

public class EmbeddedLocation extends Location {

    private final Room room;

    public EmbeddedLocation(String name, Room room) {
        super(name);
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

}
