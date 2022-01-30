package cz.cvut.fel.smarthome.controller.event_channel;

import cz.cvut.fel.smarthome.Reporter;
import cz.cvut.fel.smarthome.model.event.Event;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;
import cz.cvut.fel.smarthome.controller.basic.SmartController;

/**
 * Channel for smart home event processing
 * Represents logic of smart home
 */
public class SmartEventChannel extends EventChannel {

    @Inject
    private SmartController smartController;
    @Inject
    private Reporter reporter;

    public SmartEventChannel() {
        super(1);
    }

    @Override
    protected Boolean process(Event e) {
        switch(e.getEventType()) {
            case E_DARK -> {
                smartController.openBlinds();
                reporter.report("\n" + e + "\n");
                return true;
            }
            case E_LIGHT -> {
                smartController.closeBlinds();
                reporter.report("\n" + e + "\n");
                return true;
            }
            case E_OVERLOAD -> {
                smartController.turnOffAllDevice();
                reporter.report("\n" + e + "\n");
                return true;
            }
            case E_NORMAL -> {
                //TODO all are happy
            }
        }

        return false;
    }
}