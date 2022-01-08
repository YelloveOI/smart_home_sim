package cz.cvut.fel.smarthome.model.device;

import cz.cvut.fel.smarthome.model.Action;

import java.util.Map;

public class Device implements IControl, IData {

    private DeviceStateType currentState;

    private Double durability;

    private Action manual;

    private Map<DeviceStateType, Consumption> stateConsumptionMap;


    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

    }

    @Override
    public Consumption getActiveConsumption() {
        return null;
    }

    @Override
    public Consumption getIdleConsumption() {
        return null;
    }

    @Override
    public Consumption getInactiveConsumption() {
        return null;
    }

    @Override
    public Double getDurability() {
        return null;
    }

    public void generateEvent(){

    }

    public void processEvent(){

    }
}
