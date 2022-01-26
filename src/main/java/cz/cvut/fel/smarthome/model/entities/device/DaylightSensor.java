package cz.cvut.fel.smarthome.model.entities.device;

import cz.cvut.fel.smarthome.model.entities.Command;
import cz.cvut.fel.smarthome.model.entities.basic.Consumer;
import cz.cvut.fel.smarthome.model.entities.basic.Locatable;
import cz.cvut.fel.smarthome.model.event.Event;
import cz.cvut.fel.smarthome.model.event.EventType;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

public class DaylightSensor extends AbstractSimpleDevice {

    public DaylightSensor(String id, String location, Double activeConsumption) {
        super(
                "SENSOR_" + id,
                Set.of("OFF", "LIGHT", "DARK"),
                new Consumer(activeConsumption, "W"),
                "OFF",
                new Locatable(location)
        );
    }

    @Override
    public String getCurrentState() {
        Random rnd = new Random();
        if(Objects.equals(currentState, "LIGHT")) {
            if(rnd.nextInt(3) == 1) {
                currentState = "DARK";
            }
        } else {
            if(rnd.nextInt(3) == 1) {
                currentState = "LIGHT";
            }
        }

        return currentState;
    }

    @Override
    public Boolean command(Command command) {
        switch(command) {
            case ON -> {
                if(Objects.equals(currentState, "OFF")) {
                    currentState = "ON";
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
        }
        return false;
    }
}
