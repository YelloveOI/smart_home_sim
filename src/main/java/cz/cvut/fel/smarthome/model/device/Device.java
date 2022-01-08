package cz.cvut.fel.smarthome.model.device;

import cz.cvut.fel.smarthome.model.Action;
import cz.cvut.fel.smarthome.model.Const;

import java.util.Map;

public class Device implements IControl, IData {

    private final String name;
    private DeviceStateType currentState;
    private Double durability;
    private Map<DeviceStateType, Consumption> stateConsumptionMap;
    private boolean isBroken;

    public Device(String name, Map<DeviceStateType, Consumption> stateConsumptionMap) {
        this.currentState = DeviceStateType.INACTIVE;
        this.durability = 1d;
        this.stateConsumptionMap = stateConsumptionMap;
        this.isBroken = false;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void wearOut() {
        durability -= Const.wearOut;
        if(durability < 0) {
            isBroken = true;
            //TODO Event "im broken"
        }
    }

    public Boolean isBroken() {
        return isBroken;
    }

    @Override
    public void turnOn() {
        if(isBroken) {
            //TODO Event "im broken"
        }
        currentState = DeviceStateType.ACTIVE;
        //TODO Event "im on"
    }

    @Override
    public void turnOff() {
        currentState = DeviceStateType.INACTIVE;
        //TODO Event "im off"
    }

    @Override
    public Consumption getCurrentConsumption() {
        return stateConsumptionMap.get(currentState);
    }

}
