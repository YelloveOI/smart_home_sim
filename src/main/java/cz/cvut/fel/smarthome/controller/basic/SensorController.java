package cz.cvut.fel.smarthome.controller.basic;

import cz.cvut.fel.smarthome.controller.EventController;
import cz.cvut.fel.smarthome.Reporter;
import cz.cvut.fel.smarthome.model.entities.device.AbstractSimpleDevice;
import cz.cvut.fel.smarthome.model.event.Event;
import cz.cvut.fel.smarthome.model.event.EventType;
import cz.cvut.fel.smarthome.model.service.SensorService;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;
import javassist.NotFoundException;

/**
 * Implements simple sensor's use-cases
 * Process exceptions to services
 * Throw messages to reporter
 */
public class SensorController {

    @Inject
    private SensorService sensorService;
    @Inject
    private EventController eventController;
    @Inject
    private Reporter reporter;


    public void trigger(String sensorID) {
        try {
            sensorService.trigger(sensorID);
            reporter.report("Sensor " + sensorID + " triggered");
            AbstractSimpleDevice device = sensorService.getSensor(sensorID);
            Event<AbstractSimpleDevice> event;

            switch(device.getState()) {
                case S_DARK -> {
                    event = new Event<>(device, 1, EventType.E_DARK, "Sensor detected a lack of light");
                    eventController.notify(event);
                }
                case S_LIGHT -> {
                    event = new Event<>(device, 1, EventType.E_LIGHT, "Sensor detected too much light");
                    eventController.notify(event);
                }
                case S_OVERLOAD -> {
                    event = new Event<>(device, 2, EventType.E_OVERLOAD, "Sensor detected overload");
                    eventController.notify(event);
                }
            }
        } catch (NotFoundException e) {
            System.out.println(e);
        }
    }

}
