package cz.cvut.fel.smarthome.model.basic;

import cz.cvut.fel.smarthome.model.basic.interfaces.IConsumer;

import java.text.DecimalFormat;
import java.time.LocalDateTime;


/**
 * A primitive class for consumer entities
 * Turns OFF/ON by it's current state and keeps records
 */
public class Consumer implements IConsumer {

    private final Double consumption;
    private final String unit;
    private Boolean isActive;
    private Double consumed;

    public Consumer(Double consumption, String unit) {
        this.consumption = consumption;
        this.unit = unit;
        this.isActive = false;
        this.consumed = 0d;
    }

    @Override
    public String getConsumptionUnit() {
        return unit;
    }

    //unit/hour
    @Override
    public Double getConsumed() {
        if(isActive) {
            consumed += 24 * consumption;
        }

        return consumed;
    }

    @Override
    public void powerButton() {
        if(isActive) {
            getConsumed();
            isActive = false;
        } else {
            isActive = true;
        }
    }

    @Override
    public String toString() {
        return "Consumed:\t" + new DecimalFormat("#0.00").format(getConsumed()) + unit + "\n";
    }

}
