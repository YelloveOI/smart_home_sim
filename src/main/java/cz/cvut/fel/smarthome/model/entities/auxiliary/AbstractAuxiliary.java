package cz.cvut.fel.smarthome.model.entities.auxiliary;

import cz.cvut.fel.smarthome.model.entities.basic.AbstractEntity;
import cz.cvut.fel.smarthome.model.entities.basic.Usable;

public abstract class AbstractAuxiliary extends AbstractEntity<String> {

    protected final Usable usable;

    protected Boolean isAvailable;

    public AbstractAuxiliary(String s, Usable usable) {
        super(s);
        this.usable = usable;
        this.isAvailable = true;
    }

    public Boolean use() {
        if(usable.isBroken()) {
            isAvailable = false;
        }
        if(isAvailable) {
            usable.use();
            isAvailable = false;
            return true;
        }
        return false;
    }

    public void stopUse() {
        if(!isAvailable) {
            isAvailable = true;
        }
    }

    public abstract void repair();

    @Override
    public String toString() {
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
