package cz.cvut.fel.smarthome.model.service.event_channel;
//
//import cz.cvut.fel.smarthome.model.event.Event;
//import cz.cvut.fel.smarthome.model.service.event_channel.PersonEventChannel;
//import cz.cvut.fel.smarthome.model.service.event_channel.ReportEventChannel;
//import cz.cvut.fel.smarthome.model.service.event_channel.SmartEventChannel;
//
//public class EventService {
//
//    private final ReportEventChannel reportEventChannel;
//    private final SmartEventChannel smartEventChannel;
//    private final PersonEventChannel personEventChannel;
//
//    public EventService() {
//        this.personEventChannel = new PersonEventChannel();
//        this.smartEventChannel = new SmartEventChannel(personEventChannel);
//        this.reportEventChannel = new ReportEventChannel(smartEventChannel);
//    }
//
//    public void notify(Event e) {
//        reportEventChannel.notify(e);
//    }
//
//}
