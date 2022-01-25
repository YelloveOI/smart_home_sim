package cz.cvut.fel.smarthome.model.entities.basic;

import cz.cvut.fel.smarthome.model.entities.basic.interfaces.IStorage;

public class Storage implements IStorage {

    private Integer itemQuantity;

    public Storage(Integer itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    @Override
    public Boolean get() {
        Boolean res = isEmpty();
        itemQuantity--;
        return res;
    }

    @Override
    public void put(Integer itemQuantity) {
        this.itemQuantity += itemQuantity;
    }

    @Override
    public Boolean isEmpty() {
        return itemQuantity <= 0;
    }
}
