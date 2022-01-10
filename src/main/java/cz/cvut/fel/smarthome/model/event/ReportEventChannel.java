package cz.cvut.fel.smarthome.model.event;

public class ReportEventChannel implements EventChannel {

    @Override
    public void get(Event e) {
        System.out.println(e);
    }
}
