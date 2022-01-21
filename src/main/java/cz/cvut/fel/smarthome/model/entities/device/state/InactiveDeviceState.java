package cz.cvut.fel.smarthome.model.entities.device.state;

import cz.cvut.fel.smarthome.model.entities.device.ConsumptionType;
import cz.cvut.fel.smarthome.model.entities.device.Device;

public class InactiveDeviceState extends DeviceState {
    public InactiveDeviceState(Device device) {
        super(device);
    }

    @Override
    public void turnOn() {
        if(device.wearOut()) {
            device.setDeviceState(new BrokenDeviceState(device));
        } else {
            device.setDeviceState(new IdleDeviceState(device));
        }
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
    public void misuse() {
        device.wearOut();
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
        return false;
    }

    @Override
    public Boolean isAvailable() {
        return false;
    }
}
