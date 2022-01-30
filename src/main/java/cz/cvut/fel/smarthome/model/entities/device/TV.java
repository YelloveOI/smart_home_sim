package cz.cvut.fel.smarthome.model.entities.device;

import cz.cvut.fel.smarthome.model.entities.Command;
import cz.cvut.fel.smarthome.model.entities.State;
import cz.cvut.fel.smarthome.model.basic.Consumer;
import cz.cvut.fel.smarthome.model.basic.Usable;

import java.util.Objects;

public class TV extends AbstractUsableDevice {

    public TV(String id, Double activeConsumption) {
        super(
                id,
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
            state = State.S_BROKEN;
            return false;
        }

        switch (command) {
            case C_ON -> {
                if(Objects.equals(state, State.S_OFF)) {
                    state = State.S_IDLE;
                    consumer.powerButton();
                    return true;
                }
            }
            case C_OFF -> {
                if(Objects.equals(state, State.S_IDLE)) {
                    state = State.S_OFF;
                    consumer.powerButton();
                    return true;
                }
            }
            case C_PLAY -> {
                if(Objects.equals(state,State.S_IDLE)) {
                    usable.use();
                    state = State.S_PLAYING;
                    return true;
                }
            }
            case C_STOP -> {
                if(Objects.equals(state,State.S_PLAYING)) {
                    usable.use();
                    state = State.S_IDLE;
                    return true;
                }
            }
        }
        return false;
    }

}
