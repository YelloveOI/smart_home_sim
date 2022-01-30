package cz.cvut.fel.smarthome.model.entities.device;

import cz.cvut.fel.smarthome.model.entities.Command;
import cz.cvut.fel.smarthome.model.entities.State;
import cz.cvut.fel.smarthome.model.basic.Consumer;

import java.util.Objects;
import java.util.Random;

public class Fuse extends AbstractSimpleDevice {

    public Fuse(String id, Double activeConsumption) {
        super(
                "SENSOR_F_" + id,
                new Consumer(activeConsumption, "W"),
                State.S_OFF
        );
    }

    @Override
    public Boolean command(Command command) {
        switch(command) {
            case C_ON -> {
                if(Objects.equals(state, State.S_OFF)) {
                    Random rnd = new Random();
                    state = State.S_NORMAL;
                    consumer.powerButton();
                    return true;
                }
            }
            case C_OFF -> {
                if(Objects.equals(state, State.S_ON)) {
                    state = State.S_OFF;
                    consumer.powerButton();
                    return true;
                }
            }
            case C_TRIGGER -> {
                if(Objects.equals(state, State.S_OFF)) {
                    return false;
                }
                if(Objects.equals(state, State.S_NORMAL)) {
                    state = State.S_OVERLOAD;
                    return true;
                }
                if(Objects.equals(state, State.S_OVERLOAD)) {
                    state = State.S_NORMAL;
                    return true;
                }
            }
        }
        return false;
    }

}
