package cz.cvut.fel.smarthome.model.entities.auxiliary;

public class Car extends Auxiliary {

    public Car(String name, String location, Integer durability) {
        super(name, location, durability);
    }

    @Override
    public void repair() {
        //TODO
    }
}
