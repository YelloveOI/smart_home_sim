package cz.cvut.fel.smarthome.model.device;

import java.util.List;

public class StorageDevice extends Device {

    private List<StorageItem> storageItems;


    public String poll() {
        return null;
    }

    public String get(String item) {
        return null;
    }

    public void put(String item) {
    }

    public int quantityOf(String item) {
        return 0;
    }

    public int totalQuantity() {
        return 0;
    }

}
