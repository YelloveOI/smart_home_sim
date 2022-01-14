package cz.cvut.fel.smarthome.model.location;

import cz.cvut.fel.smarthome.model.device.Device;

public class EmbeddedLocation extends Location {

    private final Room room;
    private final Device embeddedDevice;

    public EmbeddedLocation(String name, Room room, Device embeddedDevice) {
        super(name);
        this.room = room;
        this.embeddedDevice = embeddedDevice;
    }

    public Room getRoom() {
        return room;
    }

    public Device getEmbeddedDevice() {
        return embeddedDevice;
    }
}
