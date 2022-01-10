package cz.cvut.fel.smarthome.model.interfaces;

public interface IData extends INamed {

    Double getCurrentConsumption();

    Boolean isBroken();

}
