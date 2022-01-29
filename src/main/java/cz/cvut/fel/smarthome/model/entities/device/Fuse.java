package cz.cvut.fel.smarthome.model.entities.device;

import cz.cvut.fel.smarthome.model.entities.Command;
import cz.cvut.fel.smarthome.model.entities.State;
import cz.cvut.fel.smarthome.model.entities.basic.Consumer;
import cz.cvut.fel.smarthome.model.event.Event;
import cz.cvut.fel.smarthome.model.event.EventType;

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
                if(Objects.equals(currentState, State.S_OFF)) {
                    Random rnd = new Random();
                    currentState = State.S_NORMAL;
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
                if(Objects.equals(currentState, State.S_OFF)) {
                    return false;
                }
                if(Objects.equals(currentState, State.S_NORMAL)) {
                    currentState = State.S_OVERLOAD;
                    return true;
                }
                if(Objects.equals(currentState, State.S_OVERLOAD)) {
                    currentState = State.S_NORMAL;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Event<Fuse> getEvent() {
        switch(currentState) {
            case S_NORMAL -> {
                return new Event<>(this, 2, EventType.E_NORMAL, "Sensor " + getId() + " says that current is normal");
            }
            case S_OVERLOAD -> {
                return new Event<>(this, 2, EventType.E_OVERLOAD, "Sensor " + getId() + " detected overload");
            }
        }

        return null;
    }

}
