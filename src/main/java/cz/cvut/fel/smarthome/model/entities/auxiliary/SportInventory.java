package cz.cvut.fel.smarthome.model.entities.auxiliary;

import cz.cvut.fel.smarthome.model.entities.basic.Usable;

public class SportInventory extends AbstractAuxiliary {

    public SportInventory(String s, Integer durability) {
        super(
                s,
                new Usable(durability)
        );
    }

    @Override
    public void repair() {
        //TODO
    }
}
