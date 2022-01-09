package cz.cvut.fel.smarthome.model;

import cz.cvut.fel.smarthome.model.actor.action.Action;
import cz.cvut.fel.smarthome.model.device.Device;

public class Sensor<T extends Device> {

    private final String name;
    private final Class<T> relatedDeviceType;
    private final Action triggerAction;

    public Sensor(String name, Class<T> relatedDeviceType, Action triggerAction) {
        this.name = name;
        this.relatedDeviceType = relatedDeviceType;
        this.triggerAction = triggerAction;
    }


}
