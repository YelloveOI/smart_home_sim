package cz.cvut.fel.smarthome.model.entities;

import cz.cvut.fel.smarthome.model.entities.basic.Locatable;
import cz.cvut.fel.smarthome.model.entities.basic.Usable;
import cz.cvut.fel.smarthome.model.entities.basic.interfaces.ILocateable;
import cz.cvut.fel.smarthome.model.entities.basic.interfaces.IUsable;

public class Auxiliary extends AbstractEntity<String> implements IUsable, ILocateable {

    private final Usable usable;
    private final Locatable locateable;

    public Auxiliary(String name, String location, Integer durability, String preferredLocation) {
        super(name);
        this.usable = new Usable(durability);
        this.locateable = new Locatable(preferredLocation);
    }

    @Override
    public String getLocation() {
        return locateable.getLocation();
    }

    @Override
    public void setLocation(String location) {
        locateable.setLocation(location);
    }

    @Override
    public void locateBack() {
        locateable.locateBack();
    }

    @Override
    public Boolean isAvailable() {
        return usable.isAvailable();
    }

    @Override
    public Boolean isBroken() {
        return usable.isBroken();
    }

    @Override
    public Boolean startUse() {
        return usable.startUse();
    }

    @Override
    public void stopUse() {
        usable.stopUse();
    }

    @Override
    public void misuse() {
        usable.stopUse();
    }
}
