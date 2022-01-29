package cz.cvut.fel.smarthome.controller.basic;

import cz.cvut.fel.smarthome.controller.EventController;
import cz.cvut.fel.smarthome.model.service.SensorService;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;
import javassist.NotFoundException;

public class SensorController {

    @Inject
    private SensorService sensorService;
    @Inject
    private EventController eventController;

    public void trigger(String sensorID) {
        try {
            sensorService.trigger(sensorID);
            eventController.notify(sensorService.getSensor(sensorID).getEvent());
        } catch (NotFoundException e) {
            System.out.println(e);
        }
    }

}
