package cz.cvut.fel.smarthome.controller.event_channel;

import cz.cvut.fel.smarthome.model.event.Event;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;
import cz.cvut.fel.smarthome.controller.basic.SmartController;

public class SmartEventChannel extends EventChannel {

    @Inject
    private SmartController smartController;

    public SmartEventChannel(EventChannel nextChannel) {
        super(2, nextChannel);
    }

    @Override
    protected Boolean process(Event e) {
        switch(e.getEventType()) {
            case E_DARK -> {
                smartController.openBlinds();
                return true;
            }
            case E_LIGHT -> {
                smartController.closeBlinds();
                return true;
            }
            case E_OVERLOAD -> {
                smartController.turnOffAllDevice();
                //TODO person turns on all devices
                return true;
            }
            case E_NORMAL -> {
                //TODO all are happy
            }
        }

        return false;
    }
}
