package cz.cvut.fel.smarthome.model.entities.device;

import cz.cvut.fel.smarthome.model.entities.Command;
import cz.cvut.fel.smarthome.model.entities.basic.Consumer;

import java.util.Objects;
import java.util.Random;
import java.util.Set;

public class DaylightSensor extends AbstractSimpleDevice {

    public DaylightSensor(String id, Double activeConsumption) {
        super(
                "SENSOR_DL_" + id,
                Set.of("OFF", "LIGHT", "DARK"),
                new Consumer(activeConsumption, "W"),
                "OFF"
        );
    }

    @Override
    public String getCurrentState() {
        return currentState;
    }

    @Override
    public Boolean command(Command command) {
        switch(command) {
            case ON -> {
                if(Objects.equals(currentState, "OFF")) {
                    Random rnd = new Random();
                    if(rnd.nextBoolean()) {
                        currentState = "LIGHT";
                    } else {
                        currentState = "DARK";
                    }
                    consumer.powerButton();
                    return true;
                }
            }
            case OFF -> {
                if(Objects.equals(currentState, "ON")) {
                    currentState = "OFF";
                    consumer.powerButton();
                    return true;
                }
            }
            case TRIGGER -> {
                if(Objects.equals(currentState, "LIGHT")) {
                    currentState = "DARK";
                    return true;
                }
                if(Objects.equals(currentState, "DARK")) {
                    currentState = "LIGHT";
                    return true;
                }
            }
        }
        return false;
    }
}
