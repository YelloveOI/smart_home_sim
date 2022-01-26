package cz.cvut.fel.smarthome.model.entities.auxiliary;

public class SportInventory extends AbstractAuxiliary {

    public SportInventory(String name, String location, Integer durability) {
        super("SPORT_" + name, location, durability);
    }

    @Override
    public void repair() {
        //TODO
    }
}
