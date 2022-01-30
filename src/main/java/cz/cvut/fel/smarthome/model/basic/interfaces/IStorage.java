package cz.cvut.fel.smarthome.model.basic.interfaces;

public interface IStorage {

    Boolean get(String itemType);

    Boolean put(String itemType, Integer itemQuantity);

    Boolean isEmpty();

    Integer getQuantityOf(String itemType);

}
