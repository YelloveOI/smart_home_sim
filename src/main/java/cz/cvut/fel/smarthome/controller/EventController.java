package cz.cvut.fel.smarthome.controller;

import cz.cvut.fel.smarthome.controller.event_channel.PersonEventChannel;
import cz.cvut.fel.smarthome.controller.event_channel.ReportEventChannel;
import cz.cvut.fel.smarthome.controller.event_channel.SmartEventChannel;
import cz.cvut.fel.smarthome.model.event.Event;

public class EventController {

    private final ReportEventChannel reportEventChannel;
    private final SmartEventChannel smartEventChannel;
    private final PersonEventChannel personEventChannel;

    public EventController() {
        this.personEventChannel = new PersonEventChannel();
        this.smartEventChannel = new SmartEventChannel(personEventChannel);
        this.reportEventChannel = new ReportEventChannel(smartEventChannel);
    }

    public void notify(Event e) {
        reportEventChannel.notify(e);
    }

}
