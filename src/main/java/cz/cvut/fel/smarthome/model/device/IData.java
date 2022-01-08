package cz.cvut.fel.smarthome.model.device;

public interface IData {

    Consumption getActiveConsumption();

    Consumption getIdleConsumption();

    Consumption getInactiveConsumption();

    Double getDurability();

}
