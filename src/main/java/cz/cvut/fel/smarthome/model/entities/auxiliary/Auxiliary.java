package cz.cvut.fel.smarthome.model.entities.auxiliary;

import cz.cvut.fel.smarthome.model.entities.AbstractEntity;
import cz.cvut.fel.smarthome.model.entities.basic.Locatable;
import cz.cvut.fel.smarthome.model.entities.basic.Usable;

public abstract class Auxiliary extends AbstractEntity<String> {

    protected final Usable usable;
    protected final Locatable locatable;

    protected Boolean isAvailable;

    public Auxiliary(String name, String location, Integer durability) {
        super(name);
        this.usable = new Usable(durability);
        this.locatable = new Locatable(location);
        this.isAvailable = true;
    }

    public Boolean use() {
        if(usable.isBroken()) {
            isAvailable = false;
        }
        if(isAvailable) {
            usable.use();
            isAvailable = false;
            locatable.setLocation("OUTSIDE");
            return true;
        }
        return false;
    }

    public void stopUse() {
        if(!isAvailable) {
            isAvailable = true;
            locatable.locateBack();
        }
    }

    public abstract void repair();

}
