package cz.cvut.fel.smarthome.model.device;

import java.util.Map;
import java.util.Objects;

public class StorageDevice extends Device {

    private String itemType;
    private int quantity;

    public StorageDevice(Map<DeviceStateType, Consumption> stateConsumptionMap, String itemType) {
        super(stateConsumptionMap);
        this.itemType = itemType;
    }


    public boolean get(String item) {
        if(quantity > 0) {
            if(Objects.equals(itemType, item)) {
                quantity--;
                return true;
            }
        }

        return false;
    }

    public boolean put(String item) {
        if(Objects.equals(item, itemType)) {
            quantity++;
            return true;
        }

        return false;
    }

    public boolean isEmpty() {
        return quantity <= 0;
    }

}
