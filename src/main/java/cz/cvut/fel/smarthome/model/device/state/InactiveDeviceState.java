package cz.cvut.fel.smarthome.model.device.state;

import cz.cvut.fel.smarthome.model.device.ConsumptionType;
import cz.cvut.fel.smarthome.model.device.Device;

public class InactiveDeviceState extends DeviceState {
    public InactiveDeviceState(Device device) {
        super(device);
    }

    @Override
    public void turnOn() {
        if(device.wearOut()) {
            device.setDeviceState(new BrokenDeviceState(device));
        } else {
            device.setDeviceState(new ActiveDeviceState(device));
        }
    }

    @Override
    public void turnOff() {
    }

    @Override
    public void startUse() {
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
        return false;
    }

}
