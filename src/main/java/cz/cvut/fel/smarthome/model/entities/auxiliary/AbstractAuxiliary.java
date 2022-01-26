package cz.cvut.fel.smarthome.model.entities.auxiliary;

import cz.cvut.fel.smarthome.model.entities.basic.AbstractEntity;
import cz.cvut.fel.smarthome.model.entities.basic.Locatable;
import cz.cvut.fel.smarthome.model.entities.basic.Usable;

public abstract class AbstractAuxiliary extends AbstractEntity<String> {

    protected final Usable usable;
    protected final Locatable locatable;

    protected Boolean isAvailable;

    public AbstractAuxiliary(String s, Usable usable, Locatable locatable) {
        super(s);
        this.usable = usable;
        this.locatable = locatable;
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

    public String getData() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("> Auxiliary")
                .append("\n\t")
                .append("State:\n\t");
        if(isAvailable) {
            sb.append("AVAILABLE");
        } else {
            sb.append("NOT_AVAILABLE");
        }
        sb.append("\n\t");
        sb.append(usable);

        return sb.toString();
    }

}
