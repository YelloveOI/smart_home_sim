package cz.cvut.fel.smarthome.model.device.state;

import cz.cvut.fel.smarthome.model.device.ConsumptionType;
import cz.cvut.fel.smarthome.model.device.Device;

import java.util.Set;

public class ActiveDeviceState extends DeviceState {
    public ActiveDeviceState(Device device) {
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
        device.setDeviceState(new IdleDeviceState(device));
    }

    @Override
    public Double getCurrentConsumption() {
        return device.getActiveConsumption();
    }

    @Override
    public ConsumptionType getConsumptionType() {
        return device.getConsumptionType();
    }

    @Override
    public Boolean isBroken() {
        return false;
    }


}
