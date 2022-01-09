package cz.cvut.fel.smarthome.model.event;

public abstract class Event<T> {

    protected final Class<T> receiverType;

    public Event(Class<T> receiverType) {
        this.receiverType = receiverType;
    }

    

}
