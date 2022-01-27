package cz.cvut.fel.smarthome.model.entities.device;

import cz.cvut.fel.smarthome.model.entities.Command;
import cz.cvut.fel.smarthome.model.entities.State;
import cz.cvut.fel.smarthome.model.entities.basic.Consumer;
import cz.cvut.fel.smarthome.model.entities.basic.Usable;

import java.util.Objects;
import java.util.Set;

public class TV extends AbstractUsableDevice {

    public TV(String id, Double activeConsumption) {
        super(
                "TV_" + id,
                new Consumer(activeConsumption, "W"),
                State.S_OFF,
                new Usable(100)
        );
    }

    @Override
    public void repair() {
        //TODO
    }

    @Override
    public Boolean command(Command command) {

        if(usable.isBroken()) {
            currentState = State.S_BROKEN;
            return false;
        }

        switch (command) {
            case C_ON -> {
                if(Objects.equals(currentState, State.S_OFF)) {
                    currentState = State.S_IDLE;
                    consumer.powerButton();
                    return true;
                }
            }
            case C_OFF -> {
                if(Objects.equals(currentState, State.S_IDLE)) {
                    currentState = State.S_OFF;
                    consumer.powerButton();
                    return true;
                }
            }
            case C_PLAY -> {
                if(Objects.equals(currentState,State.S_IDLE)) {
                    usable.use();
                    currentState = State.S_PLAYING;
                    return true;
                }
            }
            case C_STOP -> {
                if(Objects.equals(currentState,State.S_PLAYING)) {
                    usable.use();
                    currentState = State.S_IDLE;
                    return true;
                }
            }
        }
        return false;
    }
}
