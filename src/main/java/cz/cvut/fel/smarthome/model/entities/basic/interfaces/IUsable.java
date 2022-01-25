package cz.cvut.fel.smarthome.model.entities.basic.interfaces;

public interface IUsable {

    Boolean isAvailable();

    Boolean isBroken();

    Boolean startUse();

    void stopUse();

    void misuse();

    void repair();

}
