package cz.cvut.fel.smarthome.model.event.event_context;

import cz.cvut.fel.smarthome.model.entities.auxiliary.Auxiliary;
import cz.cvut.fel.smarthome.model.entities.device.Device;
import cz.cvut.fel.smarthome.model.event.Event;
import cz.cvut.fel.smarthome.model.event.PlainEvent;

import java.time.LocalDateTime;

public class AuxiliaryEventContext {

    public static Event startUse(Auxiliary auxiliary) {
        return new PlainEvent(
                Device.class, auxiliary.getName(), LocalDateTime.now(),
                "used by sbd",
                1
        );
    }

    public static Event stopUse(Auxiliary auxiliary) {
        return new PlainEvent(
                Device.class, auxiliary.getName(), LocalDateTime.now(),
                "stopped use by sbd",
                1
        );
    }

    public static Event imUnavailable(Auxiliary auxiliary) {
        return new PlainEvent(
                Device.class, auxiliary.getName(), LocalDateTime.now(),
                "is unavailable",
                1
        );
    }

}
