package cz.cvut.fel.smarthome.model.event;

import cz.cvut.fel.smarthome.model.device.Device;

import java.util.Set;

public class DeviceEventProcessor {

    private final Set<Device> devicePool;

    public DeviceEventProcessor(Set<Device> devicePool) {
        this.devicePool = devicePool;
    }

//    public void getEvent(Event event) {
//        devicePool.stream()
//                .filter(device -> device.getDeviceType().equals(event.handlerDisc))
//                .forEach(event::visit);
//    }

}
