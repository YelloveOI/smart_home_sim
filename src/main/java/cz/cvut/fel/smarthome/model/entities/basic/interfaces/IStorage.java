package cz.cvut.fel.smarthome.model.entities.basic.interfaces;

public interface IStorage {

    Boolean get();

    void put(Integer itemQuantity);

    Boolean isEmpty();

}
