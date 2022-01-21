package cz.cvut.fel.smarthome.model.entities.device.state;

import cz.cvut.fel.smarthome.model.entities.device.ConsumptionType;
import cz.cvut.fel.smarthome.model.entities.device.Device;

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

    @Override
    public Boolean isAvailable() {
        return false;
    }

    @Override
    public void misuse() {
        device.wearOut();
    }
}
