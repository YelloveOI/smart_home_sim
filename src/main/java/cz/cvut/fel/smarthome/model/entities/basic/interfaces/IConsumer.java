package cz.cvut.fel.smarthome.model.entities.basic.interfaces;

public interface IConsumer {

    //TODO consumption as class
    String getConsumptionUnit();

    Double getConsumed();

    void powerButton();

}
