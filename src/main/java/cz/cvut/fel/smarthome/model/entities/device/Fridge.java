package cz.cvut.fel.smarthome.model.entities.device;

import cz.cvut.fel.smarthome.model.entities.Command;
import cz.cvut.fel.smarthome.model.entities.State;
import cz.cvut.fel.smarthome.model.basic.Consumer;
import cz.cvut.fel.smarthome.model.basic.Storage;

import java.util.Objects;
import java.util.Set;

public class Fridge extends AbstractStorageDevice {

    public Fridge(String id, String location, Double activeConsumption) {
        super(
                "FRIDGE_" + id,
                new Consumer(activeConsumption, "W"),
                State.S_OFF,
                new Storage(Set.of("FOOD"))
        );
    }

    @Override
    public Boolean command(Command command) {
        switch(command) {
            case C_ON -> {
                if(Objects.equals(state, State.S_OFF)) {
                    state = State.S_OPENED;
                    consumer.powerButton();
                    return true;
                }
            }
            case C_OFF -> {
                if(!Objects.equals(state, State.S_OFF)) {
                    state = State.S_OFF;
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
