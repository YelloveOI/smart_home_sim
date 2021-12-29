package cz.cvut.fel.smarthome.model.devices;

import java.util.Map;

public abstract class Device {

    private Map<DeviceState, Double> energyConsumptions;
    private String name;
    private String manual;

    public Device() {
    }

    public Map<DeviceState, Double> getEnergyConsumptions() {
        return energyConsumptions;
    }

    public void setEnergyConsumptions(Map<DeviceState, Double> energyConsumptions) {
        this.energyConsumptions = energyConsumptions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManual() {
        return manual;
    }

    public void setManual(String manual) {
        this.manual = manual;
    }
}
