package cz.cvut.fel.smarthome.model.event;

public class ReportEvent<T> extends Event<T> {

    private final String description;

    public ReportEvent(T sender, String description) {
        super(sender, 1);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        //TODO
        return "";
    }
}
