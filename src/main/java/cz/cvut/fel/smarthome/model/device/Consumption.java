package cz.cvut.fel.smarthome.model.device;

public class Consumption {

    private String consumptionType;
    private Double consumptionValue;

    public Consumption(String consumptionType, Double consumptionValue) {
        this.consumptionType = consumptionType;
        this.consumptionValue = consumptionValue;
    }

    public String getConsumptionType() {
        return consumptionType;
    }

    public void setConsumptionType(String consumptionType) {
        this.consumptionType = consumptionType;
    }

    public Double getConsumptionValue() {
        return consumptionValue;
    }

    public void setConsumptionValue(Double consumptionValue) {
        this.consumptionValue = consumptionValue;
    }
}
