package cz.cvut.fel.smarthome;

import cz.cvut.fel.smarthome.controller.ActivityController;
import cz.cvut.fel.smarthome.controller.BusynessController;
import cz.cvut.fel.smarthome.controller.SensorEventGenerator;
import cz.cvut.fel.smarthome.controller.basic.*;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

import java.util.*;

public class Simulator {

    @Inject
    private ActivityController activityController;
    @Inject
    private BusynessController busynessController;
    @Inject
    private SmartController smartController;
    @Inject
    private SensorEventGenerator sensorEventGenerator;
    @Inject
    private Reporter reporter;

    private final Map<String, Integer> stopActivityMap;

    private Integer clock;

    public Simulator() {
        this.clock = 0;
        this.stopActivityMap = new HashMap<>();
    }

    public void start(Integer laps) {
        reporter.houseReport();

        smartController.turnOnAllDevice();

        Random rnd = new Random();

        for(int i = 0; i < laps; i++) {

            for(String s : busynessController.getFreePersonsID()) {
                activityController.startRandomPersonActivity(s, clock);
            }

            activityController.stopAllCompletedActives(clock);

            if(rnd.nextInt(5) == 0) {
                sensorEventGenerator.generateSensorEvent();
            }

            if(clock % 7 == 0) {
                reporter.aliveReport();
                reporter.deviceReport();
                reporter.auxiliaryReport();
            }

            clock++;

        }

    }

}
