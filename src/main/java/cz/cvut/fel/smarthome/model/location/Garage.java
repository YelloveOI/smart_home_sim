package cz.cvut.fel.smarthome.model.location;

public class Garage extends Room {

    private final Integer carSeatsQuantity;

    public Garage(String name, Integer floorNumber, Integer carSeatsQuantity) {
        super(name, floorNumber);
        this.carSeatsQuantity = carSeatsQuantity;
    }

}
