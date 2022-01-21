package cz.cvut.fel.smarthome.service.event_channel;

import cz.cvut.fel.smarthome.model.event.Event;

import java.io.File;
import java.io.FileWriter;

public class ReportEventChannel extends EventChannel {

    public ReportEventChannel(EventChannel nextChannel) {
        super(1, nextChannel);
    }

    @Override
    protected Boolean process(Event e) {
        try {
            FileWriter fw = new FileWriter(new File("house.log"), true);
            fw.write(e.toString());
            fw.flush();
        } catch (Exception ex) {
            System.out.println("cant reach file to log");
        }

        System.out.println(e);

        return true;
    }
}
