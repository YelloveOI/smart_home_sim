package cz.cvut.fel.smarthome.model.entities.device;

import cz.cvut.fel.smarthome.model.entities.basic.Consumer;
import cz.cvut.fel.smarthome.model.entities.basic.Locatable;
import cz.cvut.fel.smarthome.model.entities.basic.Usable;
import cz.cvut.fel.smarthome.model.entities.basic.interfaces.IUsable;

import java.util.Set;

public abstract class AbstractUsableDevice extends AbstractSimpleDevice {

    protected final Usable usable;

    public AbstractUsableDevice(String id, Set<String> stateSet, Consumer consumer, String defaultState, Locatable locatable, Usable usable) {
        super(id, stateSet, consumer, defaultState, locatable);
        this.usable = usable;
    }

    @Override
    public String getData() {
        StringBuilder sb = new StringBuilder();
        sb
                .append(super.getData())
                .append("\n\t")
                .append(usable);

        return sb.toString();
    }

    public abstract void repair();
}
