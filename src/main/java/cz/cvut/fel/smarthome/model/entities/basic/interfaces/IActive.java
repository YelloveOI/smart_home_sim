package cz.cvut.fel.smarthome.model.entities.basic.interfaces;

public interface IActive {

    String getCurrentActivity();

    void startActivity(String activity);

    void stopActivity();

}
