package cz.cvut.fel.smarthome.model.entities.device;

import cz.cvut.fel.smarthome.model.entities.Command;
import cz.cvut.fel.smarthome.model.entities.State;
import cz.cvut.fel.smarthome.model.basic.Consumer;

import java.util.Objects;

public class Blind extends AbstractSimpleDevice {

    public Blind(String id, Double activeConsumption) {
        super(
                "BLIND_" + id,
                new Consumer(activeConsumption, "W"),
                State.S_OFF
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
            case C_OPEN -> {
                if(!Objects.equals(state, State.S_OFF)) {
                    state = State.S_OPENED;
                    return true;
                }
            }
            case C_CLOSE -> {
                if(!Objects.equals(state, State.S_OFF)) {
                    state = State.S_CLOSED;
                    return true;
                }
            }
        }
        return false;
    }

}
