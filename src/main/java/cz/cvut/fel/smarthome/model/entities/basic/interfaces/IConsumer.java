package cz.cvut.fel.smarthome.model.entities.basic.interfaces;

public interface IConsumer {

    String getConsumptionUnit();

    Double getConsumed();

    void powerButton();

}
