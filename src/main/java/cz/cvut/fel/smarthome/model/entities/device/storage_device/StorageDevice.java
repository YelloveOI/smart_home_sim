package cz.cvut.fel.smarthome.model.entities.device.storage_device;

import cz.cvut.fel.smarthome.model.entities.device.ConsumptionType;
import cz.cvut.fel.smarthome.model.entities.device.Device;
import cz.cvut.fel.smarthome.model.entities.device.DeviceType;

import java.util.HashMap;
import java.util.Map;

public class StorageDevice extends Device {

    private final Map<String, Integer> itemMap;
    private final StorageDeviceType storageDeviceType;

    public StorageDevice(
            String name,
            DeviceType deviceType,
            Double activeConsumption,
            Double idleConsumption,
            ConsumptionType consumptionType,
            String location,
            StorageDeviceType storageDeviceType
    ) {
        super(name, deviceType, activeConsumption, idleConsumption, consumptionType, location);
        this.storageDeviceType = storageDeviceType;
        this.itemMap = new HashMap<>();
    }

    public boolean get(String item) {
        if(itemMap.containsKey(item)) {
            itemMap.replace(item, itemMap.get(item)-1);
            if(itemMap.get(item) <= 0) {
                itemMap.remove(item);
            }

            return true;
        }

        return false;
    }

    public void put(String item) {
        if(itemMap.containsKey(item)) {
           itemMap.replace(item, itemMap.get(item)+1);
        } else {
            itemMap.put(item, 1);
        }
    }

    public boolean isEmpty() {
        return itemMap.isEmpty();
    }

}
