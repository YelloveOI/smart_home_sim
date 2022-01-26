package cz.cvut.fel.smarthome.model.entities.device;

import cz.cvut.fel.smarthome.model.entities.basic.Consumer;
import cz.cvut.fel.smarthome.model.entities.basic.Usable;

import java.util.Set;

public abstract class AbstractUsableDevice extends AbstractSimpleDevice {

    protected final Usable usable;

    public AbstractUsableDevice(String id, Set<String> stateSet, Consumer consumer, String defaultState, Usable usable) {
        super(id, stateSet, consumer, defaultState);
        this.usable = usable;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append(super.toString())
                .append("\n\t")
                .append(usable);

        return sb.toString();
    }

    public abstract void repair();
}
