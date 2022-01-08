package cz.cvut.fel.smarthome.model;

import java.util.Set;

public class Event {

    private String senderID;
    private Set<String> receivers;
    private String subject;

    public Event(String senderID, Set<String> receivers, String subject) {
        this.senderID = senderID;
        this.receivers = receivers;
        this.subject = subject;
    }

    public String getSenderID() {
        return senderID;
    }

    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }

    public Set<String> getReceivers() {
        return receivers;
    }

    public void setReceivers(Set<String> receivers) {
        this.receivers = receivers;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
