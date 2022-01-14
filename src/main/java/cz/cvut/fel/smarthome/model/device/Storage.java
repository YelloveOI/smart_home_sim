package cz.cvut.fel.smarthome.model.device;

import java.util.Objects;
import java.util.Set;

//TODO to bind storage & device
public class Storage {

    private final String itemType;
    private int quantity;

    public Storage(String itemType) {
        this.itemType = itemType;
        this.quantity = 0;
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
