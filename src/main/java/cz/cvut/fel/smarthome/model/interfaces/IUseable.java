package cz.cvut.fel.smarthome.model.interfaces;

public interface IUseable extends INamed {

    Boolean startUse();

    void stopUse();

    void badUse();

}
