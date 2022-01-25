package cz.cvut.fel.smarthome.model.entities.device;

import cz.cvut.fel.smarthome.model.entities.Command;
import cz.cvut.fel.smarthome.model.entities.basic.Consumer;
import cz.cvut.fel.smarthome.model.entities.basic.Locatable;
import cz.cvut.fel.smarthome.model.entities.basic.Storage;

import java.util.Objects;
import java.util.Set;

public class Fridge extends AbstractStorageDevice {

    public Fridge(String id, String location, Double activeConsumption) {
        super(
                "FRIDGE_" + id,
                Set.of("OFF", "ON"),
                new Consumer(activeConsumption, "W"),
                "OFF",
                new Locatable(location),
                new Storage(Set.of("FOOD"))
        );
    }

    @Override
    public Boolean command(Command command) {
        switch(command) {
            case ON -> {
                if(Objects.equals(currentState, "OFF")) {
                    currentState = "OPEN";
                    consumer.powerButton();
                    return true;
                }
            }
            case OFF -> {
                if(!Objects.equals(currentState, "OFF")) {
                    currentState = "OFF";
                    consumer.powerButton();
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Boolean get(String itemType) {
        return storage.get(itemType);
    }

    @Override
    public Boolean put(String itemType, Integer itemQuantity) {
        return storage.put(itemType, itemQuantity);
    }

    @Override
    public Boolean isEmpty() {
        return storage.isEmpty();
    }

    @Override
    public Integer getQuantityOf(String itemType) {
        return storage.getQuantityOf(itemType);
    }
}
