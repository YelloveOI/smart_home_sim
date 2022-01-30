package cz.cvut.fel.smarthome.controller;

import cz.cvut.fel.smarthome.Reporter;
import cz.cvut.fel.smarthome.controller.basic.SmartController;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

public class PersonEventProcessor {

    @Inject
    private Reporter reporter;
    @Inject
    private SmartController smartController;

    public void turnOnElectricity(String personID) {
        reporter.report("Person " + personID + " now turned ON electricity manually");
        smartController.turnOnAllDevice();
    }

}
