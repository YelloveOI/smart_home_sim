package cz.cvut.fel.smarthome.model;

public class Action {

    private String actorID;
    private String acceptorID;
    private String act;

    public Action(String actorID, String acceptorID, String act) {
        this.actorID = actorID;
        this.acceptorID = acceptorID;
        this.act = act;
    }

    public String getActorID() {
        return actorID;
    }

    public void setActorID(String actorID) {
        this.actorID = actorID;
    }

    public String getAcceptorID() {
        return acceptorID;
    }

    public void setAcceptorID(String acceptorID) {
        this.acceptorID = acceptorID;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }
}
