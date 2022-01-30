package cz.cvut.fel.smarthome.controller;

import cz.cvut.fel.smarthome.controller.basic.SensorController;
import cz.cvut.fel.smarthome.model.entities.device.AbstractSimpleDevice;
import cz.cvut.fel.smarthome.model.repository.interfaces.SimpleDeviceRepository;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

import java.util.Objects;
import java.util.Random;
import java.util.Set;

/**
 * Generates event (in usual meaning), or rather
 * triggers random sensor
 */
public class SensorEventGenerator {

    @Inject
    private SensorController sensorController;
    @Inject
    private SimpleDeviceRepository simpleDeviceRepository;

    public void generateSensorEvent() {
        Set<AbstractSimpleDevice> sensors = simpleDeviceRepository.findAllByPredicate("SENSOR_");
        sensorController.trigger(
                sensors.stream()
                        .sorted((v1, v2) -> {
                            if(Objects.equals(v1, v2)) return 0;
                            Random rnd = new Random();
                            if(rnd.nextBoolean()) {
                                return -1;
                            } else {
                                return 1;
                            }
                        })
                        .findAny().get().getId()
        );
    }

}
