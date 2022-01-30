package cz.cvut.fel.smarthome.model.basic.interfaces;

public interface IConsumer {

    String getConsumptionUnit();

    Double getConsumed();

    void powerButton();

}
