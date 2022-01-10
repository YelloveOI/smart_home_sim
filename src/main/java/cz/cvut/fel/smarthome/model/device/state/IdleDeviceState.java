package cz.cvut.fel.smarthome.model.device.state;

import cz.cvut.fel.smarthome.model.device.ConsumptionType;
import cz.cvut.fel.smarthome.model.device.Device;

public class IdleDeviceState extends DeviceState {

    public IdleDeviceState(Device device) {
        super(device);
    }

    @Override
    public void turnOn() {
    }

    @Override
    public void turnOff() {
        if(device.wearOut()) {
            device.setDeviceState(new BrokenDeviceState(device));
        } else {
            device.setDeviceState(new InactiveDeviceState(device));
        }
    }

    @Override
    public Boolean startUse() {
        device.setDeviceState(new ActiveDeviceState(device));
        return true;
    }

    @Override
    public void stopUse() {
    }

    @Override
    public Double getCurrentConsumption() {
        return device.getIdleConsumption();
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
        return true;
    }
}
