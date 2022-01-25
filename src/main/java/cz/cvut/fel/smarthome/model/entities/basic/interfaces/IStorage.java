package cz.cvut.fel.smarthome.model.entities.basic.interfaces;

import java.util.Set;

public interface IStorage {

    Boolean get(String itemType);

    Boolean put(String itemType, Integer itemQuantity);

    Boolean isEmpty();

    Integer getQuantityOf(String itemType);

}
