package cz.cvut.fel.smarthome.model.event;

public class EventContext {

    private final static EventChannel reportChannel = new ReportEventChannel();

    public static EventChannel getReportChannel() {
        return reportChannel;
    }
}
