package cz.cvut.fel.smarthome.model.basic;

import cz.cvut.fel.smarthome.model.basic.interfaces.IStorage;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Storage implements IStorage {

    private final Set<String> itemTypeSet;
    private final Map<String, Integer> itemMap;

    public Storage(Set<String> itemTypeSet) {
        this.itemTypeSet = itemTypeSet;
        this.itemMap = new HashMap<>();

        for(String s : itemTypeSet) {
            itemMap.put(s, 0);
        }
    }

    @Override
    public Boolean get(String itemType) {
        if(!itemTypeSet.contains(itemType)) return false;
        if(itemMap.get(itemType) <= 0) return false;
        itemMap.replace(itemType, itemMap.get(itemType)-1);

        return true;
    }

    @Override
    public Boolean put(String itemType, Integer itemQuantity) {
        if(!itemTypeSet.contains(itemType)) return false;
        itemMap.replace(itemType, itemMap.get(itemType)+itemQuantity);
        return true;
    }

    @Override
    public Boolean isEmpty() {
        return itemMap.values().stream().reduce(0, (v1, v2) -> v1+v1) == 0;
    }

    @Override
    public Integer getQuantityOf(String itemType) {
        return itemMap.get(itemType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Storage:");
        for(String s : itemTypeSet) {
            sb
                    .append("\t")
                    .append(s)
                    .append(":")
                    .append(itemMap.get(s));
        }

        return sb.toString();
    }
}
