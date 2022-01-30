package cz.cvut.fel.smarthome.model.entities.device;

import cz.cvut.fel.smarthome.model.entities.State;
import cz.cvut.fel.smarthome.model.basic.Consumer;
import cz.cvut.fel.smarthome.model.basic.Usable;

/**
 * Represents a device which could be used
 */
public abstract class AbstractUsableDevice extends AbstractSimpleDevice {

    protected final Usable usable;

    public AbstractUsableDevice(String id, Consumer consumer, State defaultState, Usable usable) {
        super("USABLE_" + id, consumer, defaultState);
        this.usable = usable;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append(super.toString())
                .append(usable);

        return sb.toString();
    }

    public abstract void repair();
}
