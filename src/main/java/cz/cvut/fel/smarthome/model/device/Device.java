package cz.cvut.fel.smarthome.model.device;

import cz.cvut.fel.smarthome.model.interfaces.IControl;
import cz.cvut.fel.smarthome.model.interfaces.IData;
import cz.cvut.fel.smarthome.model.interfaces.IUseable;
import cz.cvut.fel.smarthome.model.device.state.DeviceState;
import cz.cvut.fel.smarthome.model.device.state.InactiveDeviceState;

public class Device implements IControl, IData, IUseable {

    private final String name;
    private final DeviceType deviceType;
    private final Double activeConsumption;
    private final Double idleConsumption;
    private final ConsumptionType consumptionType;
    private DeviceState deviceState;
    private Double durability;

    public Device(String name, DeviceType deviceType, Double activeConsumption, Double idleConsumption, ConsumptionType consumptionType) {
        this.name = name;
        this.deviceType = deviceType;
        this.activeConsumption = activeConsumption;
        this.idleConsumption = idleConsumption;
        this.consumptionType = consumptionType;
        this.deviceState = new InactiveDeviceState(this);
        this.durability = 1d;
    }

    public boolean wearOut() {
        durability -= Const.wearOutValue;
        return durability <= 0;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceState(DeviceState deviceState) {
        this.deviceState = deviceState;
    }

    public Double getActiveConsumption() {
        return activeConsumption;
    }

    public Double getIdleConsumption() {
        return idleConsumption;
    }

    public ConsumptionType getConsumptionType() {
        return consumptionType;
    }

    public String getName() {
        return name;
    }

    @Override
    public void turnOn() {
        deviceState.turnOn();
    }

    @Override
    public void turnOff() {
        deviceState.turnOff();
    }

    @Override
    public Double getCurrentConsumption() {
        return deviceState.getCurrentConsumption();
    }

    @Override
    public Boolean isBroken() {
        return deviceState.isBroken();
    }

    @Override
    public Boolean startUse() {
        return deviceState.startUse();
    }

    @Override
    public void stopUse() {
        deviceState.stopUse();
    }

    @Override
    public void badUse() {
        wearOut();
    }

}
