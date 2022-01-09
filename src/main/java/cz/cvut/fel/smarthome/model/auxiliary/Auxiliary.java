package cz.cvut.fel.smarthome.model.auxiliary;

public class Auxiliary {

    private final String name;
    private final AuxiliaryType destiny;
    private boolean isAvailable;

    public Auxiliary(String name, AuxiliaryType destinyType) {
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

    public String getName() {
        return name;
    }

    public AuxiliaryType getDestiny() {
        return destiny;
    }

}
