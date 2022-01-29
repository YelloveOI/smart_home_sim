package cz.cvut.fel.smarthome.controller.event_channel;

import cz.cvut.fel.smarthome.model.event.Event;
import cz.cvut.fel.smarthome.model.service.PersonService;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

public class PersonEventChannel extends EventChannel {

    @Inject
    private PersonService service;

    public PersonEventChannel() {
        super(3, null);
    }

    @Override
    protected Boolean process(Event e) {
        return false;
    }
}
