package cz.cvut.fel.smarthome.model.event;

public class ReportEventChannel implements EventChannel {

    //TODO вывод в файл
    @Override
    public void get(Event e) {
        System.out.println(e);
    }
}
