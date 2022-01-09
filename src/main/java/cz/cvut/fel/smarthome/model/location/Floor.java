package cz.cvut.fel.smarthome.model.location;

final public class Floor extends Location {
    public Floor(Location root) {
        super(root);
    }

    @Override
    public Floor addNestedLocation() {
        nestedLocations.add(new Room(this));
        return this;
    }

    @Override
    public Floor removeNestedLocation(int index) {
        nestedLocations.remove(index);
        return this;
    }

    @Override
    public Room getNestedLocation(int index) {
        return (Room) nestedLocations.get(index);
    }

    @Override
    public House getRoot() {
        return (House) root;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "nestedLocations=" + nestedLocations +
                '}';
    }
}
