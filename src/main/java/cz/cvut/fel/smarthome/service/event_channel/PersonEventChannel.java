package cz.cvut.fel.smarthome.service.event_channel;
//
//import cz.cvut.fel.smarthome.model.event.SmartEvent;
//import cz.cvut.fel.smarthome.model.event.Event;
//import cz.cvut.fel.smarthome.service.PersonService;
//import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;
//
//public class PersonEventChannel extends EventChannel {
//
//    @Inject
//    private PersonService service;
//
//    public PersonEventChannel() {
//        super(3, null);
//    }
//
//    @Override
//    protected Boolean process(Event e) {
//        //TODO
//        switch(e.getEventType()) {
//            case IM_HUNGRY -> {
//                service.feedPet((String) e.getSender().getId());
//                return false;
//            }
//            default -> {
//                //TODO "nobody can process event"
//                return true;
//            }
//        }
//    }
//}
