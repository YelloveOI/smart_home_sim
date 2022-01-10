package cz.cvut.fel.smarthome.model.interfaces;

public interface IUseable extends INamed {

    Boolean isAvailable();

    Boolean startUse();

    void stopUse();

    void badUse();


}
