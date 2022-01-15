package cz.cvut.fel.smarthome.model.event.event_context;

import cz.cvut.fel.smarthome.model.device.Device;
import cz.cvut.fel.smarthome.model.device.state.DeviceState;
import cz.cvut.fel.smarthome.model.event.Event;
import cz.cvut.fel.smarthome.model.event.PlainEvent;

import java.time.LocalDateTime;

public class DeviceEventContext {

    public static Event changeState(Device device, DeviceState to) {
        return new PlainEvent(
                Device.class, device.getName(), LocalDateTime.now(),
                "state changed from to " + to.getClass().getSimpleName(),
                1
        );
    }

}
