package cz.cvut.fel.smarthome.model;

import java.util.Set;

public class Action extends Event {

    public Action(String senderID, Set<String> receivers, String subject) {
        super(senderID, receivers, subject);
    }
}
