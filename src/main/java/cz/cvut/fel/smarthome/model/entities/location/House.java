package cz.cvut.fel.smarthome.model.entities.location;

import cz.cvut.fel.smarthome.model.entities.basic.AbstractEntity;

//TODO
public class House extends AbstractEntity<String> {

    private final Integer floorQuantity;
    private final Integer roomQuantity;
    private final Integer garageQuantity;
    private final Integer embeddedQuantity;

    public House(String name, Integer floorQuantity, Integer roomQuantity, Integer garageQuantity, Integer embeddedQuantity) {
        super(name);
        this.floorQuantity = floorQuantity;
        this.roomQuantity = roomQuantity;
        this.garageQuantity = garageQuantity;
        this.embeddedQuantity = embeddedQuantity;
    }

    public Integer getFloorQuantity() {
        return floorQuantity;
    }

    public Integer getRoomQuantity() {
        return roomQuantity;
    }

    public Integer getGarageQuantity() {
        return garageQuantity;
    }

    public Integer getEmbeddedQuantity() {
        return embeddedQuantity;
    }

}
