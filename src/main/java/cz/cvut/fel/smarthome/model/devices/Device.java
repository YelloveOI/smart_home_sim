package cz.cvut.fel.smarthome.model.devices;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class Device {

    private Map<DeviceState, Double> energyConsumptions;
    private String name;
    private String manual;

    public Device() {
        this.energyConsumptions = new HashMap<>();
    }

    public Map<DeviceState, Double> getEnergyConsumptions() {
        return energyConsumptions;
    }

    public Device setEnergyConsumptions(Map<DeviceState, Double> energyConsumptions) {
        this.energyConsumptions = energyConsumptions;
        return this;
    }

    public String getName() {
        return name;
    }

    public Device setName(String name) {
        this.name = name;
        return this;
    }

    public String getManual() {
        return manual;
    }

    public Device setManual(String manual) {
        this.manual = manual;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Device device = (Device) o;

        if (!Objects.equals(energyConsumptions, device.energyConsumptions))
            return false;
        if (!Objects.equals(name, device.name)) return false;
        return Objects.equals(manual, device.manual);
    }

    @Override
    public int hashCode() {
        int result = energyConsumptions != null ? energyConsumptions.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (manual != null ? manual.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Device{" +
                "energyConsumptions=" + energyConsumptions +
                ", name='" + name + '\'' +
                ", manual='" + manual + '\'' +
                '}';
    }
}
