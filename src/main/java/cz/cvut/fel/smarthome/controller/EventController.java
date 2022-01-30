package cz.cvut.fel.smarthome.controller;

import cz.cvut.fel.smarthome.controller.basic.SmartController;
import cz.cvut.fel.smarthome.controller.event_channel.PersonEventChannel;
import cz.cvut.fel.smarthome.controller.event_channel.SmartEventChannel;
import cz.cvut.fel.smarthome.model.event.Event;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

/**
 * Start point of event processing, aggregates EventChannels
 */
public class EventController {

    @Inject
    private SmartEventChannel smartEventChannel;
    @Inject
    private PersonEventChannel personEventChannel;

    public void init() {
        smartEventChannel.setNextChannel(personEventChannel);
    }

    public void notify(Event e) {
        smartEventChannel.notify(e);
    }

}
