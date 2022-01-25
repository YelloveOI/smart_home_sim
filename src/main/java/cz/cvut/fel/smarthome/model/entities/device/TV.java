package cz.cvut.fel.smarthome.model.entities.device;

import cz.cvut.fel.smarthome.model.entities.Command;
import cz.cvut.fel.smarthome.model.entities.basic.Consumer;
import cz.cvut.fel.smarthome.model.entities.basic.Locatable;
import cz.cvut.fel.smarthome.model.entities.basic.Usable;

import java.util.Objects;
import java.util.Set;

public class TV extends AbstractUsableDevice {

    public TV(String id, String location, Double activeConsumption) {
        super(
                "TV_" + id,
                Set.of("IDLE", "OFF", "PLAYING", "BROKEN"),
                new Consumer(activeConsumption, "W"),
                "OFF",
                new Locatable(location),
                new Usable(100)
        );
    }

    @Override
    public void repair() {
        //TODO
    }

    @Override
    Boolean command(Command command) {

        if(usable.isBroken()) {
            currentState = "BROKEN";
            return false;
        }

        switch (command) {
            case ON -> {
                if(Objects.equals(currentState, "OFF")) {
                    currentState = "IDLE";
                    consumer.powerButton();
                    return true;
                }
            }
            case OFF -> {
                if(Objects.equals(currentState, "IDLE")) {
                    currentState = "OFF";
                    consumer.powerButton();
                    return true;
                }
            }
            case PLAY -> {
                if(Objects.equals(currentState,"IDLE")) {
                    usable.use();
                    if(usable.isBroken()) {
                        currentState = "BROKEN";
                        return false;
                    }
                    currentState = "PLAYING";
                    return true;
                }
            }
            case STOP -> {
                if(Objects.equals(currentState,"PLAYING")) {
                    usable.use();
                    if(usable.isBroken()) {
                        currentState = "BROKEN";
                        return false;
                    }
                    currentState = "IDLE";
                    return true;
                }
            }
        }
        return false;
    }
}
