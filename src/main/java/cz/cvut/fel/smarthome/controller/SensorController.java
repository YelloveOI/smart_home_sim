package cz.cvut.fel.smarthome.controller;

import cz.cvut.fel.smarthome.model.service.SensorService;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;
import javassist.NotFoundException;

public class SensorController {

    @Inject
    private SensorService sensorService;

    public void trigger(String sensorID) {
        try {
            sensorService.trigger(sensorID);
        } catch (NotFoundException e) {
            System.out.println(e);
        }
    }

}
