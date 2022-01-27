package cz.cvut.fel.smarthome.model.entities.device;

import cz.cvut.fel.smarthome.model.entities.Command;
import cz.cvut.fel.smarthome.model.entities.State;
import cz.cvut.fel.smarthome.model.entities.basic.Consumer;

import java.util.Objects;
import java.util.Random;
import java.util.Set;

public class DaylightSensor extends AbstractSimpleDevice {

    public DaylightSensor(String id, Double activeConsumption) {
        super(
                "SENSOR_DL_" + id,
                new Consumer(activeConsumption, "W"),
                State.S_OFF
        );
    }

    @Override
    public Boolean command(Command command) {
        switch(command) {
            case C_ON -> {
                if(Objects.equals(currentState, State.S_OFF)) {
                    Random rnd = new Random();
                    if(rnd.nextBoolean()) {
                        currentState = State.S_LIGHT;
                    } else {
                        currentState = State.S_DARK;
                    }
                    consumer.powerButton();
                    return true;
                }
            }
            case C_OFF -> {
                if(Objects.equals(currentState, State.S_ON)) {
                    currentState = State.S_OFF;
                    consumer.powerButton();
                    return true;
                }
            }
            case C_TRIGGER -> {
                if(Objects.equals(currentState, State.S_LIGHT)) {
                    currentState = State.S_DARK;
                    return true;
                }
                if(Objects.equals(currentState, State.S_DARK)) {
                    currentState = State.S_LIGHT;
                    return true;
                }
            }
        }
        return false;
    }
}
