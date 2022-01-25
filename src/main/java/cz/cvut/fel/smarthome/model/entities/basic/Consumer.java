package cz.cvut.fel.smarthome.model.entities.basic;

import cz.cvut.fel.smarthome.model.entities.basic.interfaces.IConsumer;

import java.time.LocalDateTime;

public class Consumer implements IConsumer {

    private final Double consumption;
    private final String unit;
    private Boolean isActive;
    private LocalDateTime clock;
    private Double consumed;

    public Consumer(Double consumption, String unit) {
        this.consumption = consumption;
        this.unit = unit;
        this.isActive = false;
        this.clock = LocalDateTime.now();
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
            consumed += ((LocalDateTime.now().getSecond() - clock.getSecond()) * consumption)/60;
            clock = LocalDateTime.now();
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
            clock = LocalDateTime.now();
        }
    }
}
