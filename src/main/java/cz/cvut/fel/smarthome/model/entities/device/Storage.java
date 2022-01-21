package cz.cvut.fel.smarthome.model.entities.device;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


//TODO bind with device (solve repo's conflicts)
public class Storage {

    private final Map<String, Integer> itemMap;

    public Storage() {
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
