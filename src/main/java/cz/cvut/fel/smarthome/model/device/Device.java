package cz.cvut.fel.smarthome.model.device;

import cz.cvut.fel.smarthome.model.enums.DeviceStateType;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Device {

    private final String name;
    private final Set<Consumption> consumptions;
    private boolean isBroken;
    private double durability;

    public Device(String name, Set<Consumption> consumptions) {
        this.name = name;
        this.consumptions = consumptions;
        this.isBroken = false;
        this.durability = 1d;
    }

    public boolean isBroken() {
        return isBroken;
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

    public double getDurability() {
        return durability;
    }

    public void setDurability(double durability) {
        this.durability = durability;
    }

    public String getName() {
        return name;
    }

    public Set<Consumption> getConsumptions(DeviceStateType type) {
        return consumptions.stream()
                .filter(v -> Objects.equals(v.getDeviceStateType(), type))
                .collect(Collectors.toSet());
    }

}
