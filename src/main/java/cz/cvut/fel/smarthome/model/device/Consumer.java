package cz.cvut.fel.smarthome.model.device;

import cz.cvut.fel.smarthome.model.enums.ConsumptionType;
import cz.cvut.fel.smarthome.model.enums.DeviceStateType;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public record Consumer(String name, Set<Consumption> consumptions){

    public Set<Consumption> getConsumptions(DeviceStateType type) {
        return consumptions.stream()
                .filter(v -> Objects.equals(v.deviceStateType(), type))
                .collect(Collectors.toSet());
    }

}
