package cz.cvut.fel.smarthome.model.device.state;


import cz.cvut.fel.smarthome.model.device.ConsumptionType;
import cz.cvut.fel.smarthome.model.device.Device;

import java.util.Set;

public abstract class DeviceState {

    protected final Device device;

    public DeviceState(Device device) {
        this.device = device;
    }

    public abstract void turnOn();
    public abstract void turnOff();
    public abstract Boolean startUse();
    public abstract void stopUse();
    public abstract Double getCurrentConsumption();
    public abstract ConsumptionType getConsumptionType();
    public abstract Boolean isBroken();
    public abstract Boolean isAvailable();

}
