package cz.cvut.fel.smarthome.model.device;

import cz.cvut.fel.smarthome.model.enums.ConsumptionType;
import cz.cvut.fel.smarthome.model.enums.DeviceStateType;

public class Consumption {
    private final ConsumptionType consumptionType;
    private final DeviceStateType deviceStateType;
    private final Double value;

    public Consumption(ConsumptionType consumptionType, DeviceStateType deviceStateType, Double value) {
        this.consumptionType = consumptionType;
        this.deviceStateType = deviceStateType;
        this.value = value;
    }

    public ConsumptionType getConsumptionType() {
        return consumptionType;
    }

    public DeviceStateType getDeviceStateType() {
        return deviceStateType;
    }

    public Double getValue() {
        return value;
    }
}
