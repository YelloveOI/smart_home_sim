package cz.cvut.fel.smarthome.controller.basic;

import cz.cvut.fel.smarthome.controller.EventController;
import cz.cvut.fel.smarthome.model.entities.basic.AbstractEntity;
import cz.cvut.fel.smarthome.model.entities.device.AbstractUsableDevice;
import cz.cvut.fel.smarthome.model.event.Event;
import cz.cvut.fel.smarthome.model.event.EventType;
import cz.cvut.fel.smarthome.model.service.SmartService;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

public class SmartController {

    @Inject
    private SmartService smartService;
    @Inject
    private EventController eventController;

    public void turnOnAllDevice() {
        smartService.turnOnAllSimpleDevices();
        smartService.turnOnAllStorageDevices();
        smartService.turnOnAllUsableDevices();

        eventController.notify(new Event<AbstractEntity<String>>(
                new AbstractEntity<String>("SMART_CONTROLLER") {
                    @Override
                    public String getId() {
                        return super.getId();
                    }
                },
                1,
                EventType.E_NORMAL,
                "All devices are turned ON"
        ));
    }

    public void turnOffAllDevice() {
        smartService.turnOffAllSimpleDevices();
        smartService.turnOffAllStorageDevices();
        smartService.turnOffAllUsableDevices();

        eventController.notify(new Event<AbstractEntity<String>>(
                new AbstractEntity<String>("SMART_CONTROLLER") {
                    @Override
                    public String getId() {
                        return super.getId();
                    }
                },
                1,
                EventType.E_NORMAL,
                "All devices are turned OFF"
        ));
    }

    public void openBlinds() {
        smartService.openBlinds();

        eventController.notify(new Event<AbstractEntity<String>>(
                new AbstractEntity<String>("SMART_CONTROLLER") {
                    @Override
                    public String getId() {
                        return super.getId();
                    }
                },
                1,
                EventType.E_NORMAL,
                "All blinds are open"
        ));
    }

    public void closeBlinds() {
        smartService.closeBlinds();

        eventController.notify(new Event<AbstractEntity<String>>(
                new AbstractEntity<String>("SMART_CONTROLLER") {
                    @Override
                    public String getId() {
                        return super.getId();
                    }
                },
                1,
                EventType.E_NORMAL,
                "All blinds are closed"
        ));
    }

}
