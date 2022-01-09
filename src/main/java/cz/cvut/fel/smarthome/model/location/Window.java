package cz.cvut.fel.smarthome.model.location;

public class Window extends Room {

    private final Room room;

    public Window(String name, Room room) {
        super(name, room.getFloorNumber());
        this.room = room;
    }

    @Override
    public String toString() {
        return "Window{" +
                "room=" + room +
                '}';
    }
}
