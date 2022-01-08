package cz.cvut.fel.smarthome.model;

import cz.cvut.fel.smarthome.model.enums.AuxiliaryDestinyType;
import cz.cvut.fel.smarthome.model.enums.AuxiliaryType;

public class Auxiliary {

    private final AuxiliaryType type;
    private final String name;
    private final AuxiliaryDestinyType destiny;
    private boolean isAvailable;

    public Auxiliary(AuxiliaryType type, String name, AuxiliaryDestinyType destinyType) {
        this.type = type;
        this.name = name;
        this.destiny = destinyType;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public AuxiliaryType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public AuxiliaryDestinyType getDestiny() {
        return destiny;
    }

}
