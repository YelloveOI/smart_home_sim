package cz.cvut.fel.smarthome.model.entities.basic.interfaces;

public interface IActive {

    //TODO activity as class
    String getCurrentActivity();

    void startActivity(String activity);

    void stopActivity();

}
