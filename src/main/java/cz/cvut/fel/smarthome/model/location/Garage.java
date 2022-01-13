package cz.cvut.fel.smarthome.model.location;

import cz.cvut.fel.smarthome.model.auxiliary.Auxiliary;

import java.util.Set;

public class Garage extends Room {

    private final Set<Auxiliary> auxiliaries;

    public Garage(String name, Integer floorNumber, Integer carSeatsQuantity, Set<Auxiliary> auxiliaries) {
        super(name, floorNumber);
        this.auxiliaries = auxiliaries;
    }

    public void addAuxiliary(Auxiliary auxiliary) {
        auxiliaries.add(auxiliary);
    }

    public void removeAuxiliary(Auxiliary auxiliary) {
        auxiliaries.remove(auxiliary);
    }

    public Set<Auxiliary> getAuxiliaries() {
        return auxiliaries;
    }
}
