package cz.cvut.fel.smarthome.model.entities.auxiliary;

import cz.cvut.fel.smarthome.model.basic.Usable;

public class Car extends AbstractAuxiliary {

    public Car(String s, Integer durability) {
        super(
                "CAR_" + s,
                new Usable(durability)
        );
    }

    @Override
    public void repair() {
        usable.repair();
        //TODO
    }
}
