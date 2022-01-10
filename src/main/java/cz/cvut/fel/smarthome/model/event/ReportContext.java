package cz.cvut.fel.smarthome.model.event;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReportContext {

    private final static EventChannel reportChannel = new ReportEventChannel();

    public static EventChannel getReportChannel() {
        return reportChannel;
    }

    public static PlainEvent createReportEvent(Class sender, String senderName, String description) {
        return new PlainEvent(sender, senderName, LocalDateTime.now(), reportChannel, description);
    }

}
