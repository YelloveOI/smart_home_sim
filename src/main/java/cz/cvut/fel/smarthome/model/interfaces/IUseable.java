package cz.cvut.fel.smarthome.model.interfaces;

public interface IUseable {

    Boolean isAvailable();

    Boolean startUse();

    void stopUse();

    void badUse();

}
