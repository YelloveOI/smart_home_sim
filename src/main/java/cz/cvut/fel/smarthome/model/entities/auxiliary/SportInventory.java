package cz.cvut.fel.smarthome.model.entities.auxiliary;

import cz.cvut.fel.smarthome.model.entities.basic.Locatable;
import cz.cvut.fel.smarthome.model.entities.basic.Usable;

public class SportInventory extends AbstractAuxiliary {

    public SportInventory(String s, String location, Integer durability) {
        super(
                s,
                new Usable(durability),
                new Locatable(location)
        );
    }

    @Override
    public void repair() {
        //TODO
    }
}
