package cz.cvut.fel.smarthome.model.entities.auxiliary;

public class Car extends AbstractAuxiliary {

    public Car(String name, String location, Integer durability) {
        super("CAR_" + name, location, durability);
    }

    @Override
    public void repair() {
        //TODO
    }
}
