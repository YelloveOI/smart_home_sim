package cz.cvut.fel.smarthome.model.auxiliary;

public class Auxiliary {

    private final String name;
    private final AuxiliaryType type;

    public Auxiliary(String name, AuxiliaryType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public AuxiliaryType getType() {
        return type;
    }
}
