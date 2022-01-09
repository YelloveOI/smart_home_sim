package cz.cvut.fel.smarthome.model.device.state;

import cz.cvut.fel.smarthome.model.device.ConsumptionType;
import cz.cvut.fel.smarthome.model.device.Device;

import java.util.Set;

public class BrokenDeviceState extends DeviceState {
    public BrokenDeviceState(Device device) {
        super(device);
    }

    @Override
    public void turnOn() {
    }

    @Override
    public void turnOff() {
    }

    @Override
    public Boolean startUse() {
        return false;
    }

    @Override
    public void stopUse() {
    }

    @Override
    public Double getCurrentConsumption() {
        return 0d;
    }

    @Override
    public ConsumptionType getConsumptionType() {
        return device.getConsumptionType();
    }

    @Override
    public Boolean isBroken() {
        return true;
    }

}
