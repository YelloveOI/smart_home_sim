package cz.cvut.fel.smarthome.model.entities.device;

import cz.cvut.fel.smarthome.model.entities.AbstractEntity;
import cz.cvut.fel.smarthome.model.entities.device.state.DeviceState;
import cz.cvut.fel.smarthome.model.entities.device.state.InactiveDeviceState;
import cz.cvut.fel.smarthome.model.interfaces.IControl;
import cz.cvut.fel.smarthome.model.interfaces.IData;
import cz.cvut.fel.smarthome.model.interfaces.ILocateable;
import cz.cvut.fel.smarthome.model.interfaces.IUseable;

public class Device extends AbstractEntity<String> implements IControl, IData, IUseable, ILocateable {

    private final DeviceType deviceType;
    private final Double activeConsumption;
    private final Double idleConsumption;
    private final ConsumptionType consumptionType;
    private Double durability;
    private String location;
    transient private DeviceState deviceState;

    public Device(
            String name,
            DeviceType deviceType,
            Double activeConsumption,
            Double idleConsumption,
            ConsumptionType consumptionType,
            String location
    ) {
        super(name);
        this.deviceType = deviceType;
        this.activeConsumption = activeConsumption;
        this.idleConsumption = idleConsumption;
        this.consumptionType = consumptionType;
        this.deviceState = new InactiveDeviceState(this);
        this.durability = 1d;
        this.location = location;
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

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
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
    public Boolean isAvailable() {
        return deviceState.isAvailable();
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
    public void misuse() {
        wearOut();
    }

}
