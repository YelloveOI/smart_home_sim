package cz.cvut.fel.smarthome.controller.event_channel;

import cz.cvut.fel.smarthome.controller.BusynessController;
import cz.cvut.fel.smarthome.controller.PersonEventProcessor;
import cz.cvut.fel.smarthome.controller.basic.PersonController;
import cz.cvut.fel.smarthome.model.event.Event;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

/**
 * Channel for person event processing
 */
public class PersonEventChannel extends EventChannel {

    @Inject
    private PersonEventProcessor personEventProcessor;
    @Inject
    private BusynessController busynessController;

    public PersonEventChannel() {
        super(2);
    }

    @Override
    protected Boolean process(Event e) {
        switch(e.getEventType()) {
            case E_OVERLOAD -> {
                personEventProcessor.turnOnElectricity(busynessController.getFreePersonsID().stream().findAny().get());
                return true;
            }
        }

        return false;
    }
}
