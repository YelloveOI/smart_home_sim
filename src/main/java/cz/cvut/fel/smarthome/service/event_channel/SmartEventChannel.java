package cz.cvut.fel.smarthome.service.event_channel;

import cz.cvut.fel.smarthome.model.event.Event;
import cz.cvut.fel.smarthome.service.SmartHomeService;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

public class SmartEventChannel extends EventChannel {

    @Inject
    private SmartHomeService service;

    public SmartEventChannel(EventChannel nextChannel) {
        super(2, nextChannel);
    }

    @Override
    protected Boolean process(Event e) {
        switch(e.getEventType()) {
            case DAWN -> {
                service.closeBlinds();
                return false;
            }
            case SUNSET -> {
                service.openBlinds();
                return false;
            }
            default -> {
                return true;
            }
        }
    }
}
