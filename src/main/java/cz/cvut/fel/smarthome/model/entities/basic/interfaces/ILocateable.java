package cz.cvut.fel.smarthome.model.entities.basic.interfaces;

public interface ILocateable {

    String getLocation();

    void setLocation(String location);

    void locateBack();

}
