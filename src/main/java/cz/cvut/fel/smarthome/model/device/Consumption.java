package cz.cvut.fel.smarthome.model.device;

import cz.cvut.fel.smarthome.model.enums.ConsumptionType;
import cz.cvut.fel.smarthome.model.enums.DeviceStateType;

public record Consumption(ConsumptionType consumptionType, DeviceStateType deviceStateType, Double value) {
}