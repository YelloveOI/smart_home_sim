package cz.cvut.fel.smarthome.model.entities.auxiliary;

public class SportInventory extends Auxiliary {

    public SportInventory(String name, String location, Integer durability) {
        super(name, location, durability);
    }

    @Override
    public void repair() {
        //TODO
    }
}
