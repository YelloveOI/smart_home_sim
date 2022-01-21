package cz.cvut.fel.smarthome.model.entities.device.state;


import cz.cvut.fel.smarthome.model.entities.device.ConsumptionType;
import cz.cvut.fel.smarthome.model.entities.device.Device;
import cz.cvut.fel.smarthome.model.interfaces.IControl;
import cz.cvut.fel.smarthome.model.interfaces.IData;
import cz.cvut.fel.smarthome.model.interfaces.IUseable;

public abstract class DeviceState implements IControl, IData, IUseable {

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
