package cz.cvut.fel.smarthome.model.device;

public interface IData {

    Consumption getCurrentConsumption();

    Boolean isBroken();

}
