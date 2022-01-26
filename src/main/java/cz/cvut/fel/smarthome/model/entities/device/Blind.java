package cz.cvut.fel.smarthome.model.entities.device;

import cz.cvut.fel.smarthome.model.entities.Command;
import cz.cvut.fel.smarthome.model.entities.basic.Consumer;

import java.util.Objects;
import java.util.Set;

public class Blind extends AbstractSimpleDevice {

    public Blind(String id, Double activeConsumption) {
        super(
                "BLIND_" + id,
                Set.of("OPEN", "CLOSE", "OFF"),
                new Consumer(activeConsumption, "W"),
                "OFF"
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
            case OPEN -> {
                if(!Objects.equals(currentState, "OFF")) {
                    currentState = "OPEN";
                    return true;
                }
            }
            case CLOSE -> {
                if(!Objects.equals(currentState, "OFF")) {
                    currentState = "CLOSE";
                    return true;
                }
            }
        }
        return false;
    }
}
