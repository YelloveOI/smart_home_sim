package cz.cvut.fel.smarthome.model.entities.basic;

import cz.cvut.fel.smarthome.model.entities.basic.interfaces.IUsable;

public class Usable implements IUsable {

    private final Integer maxDurability;
    private Integer durability;
    private Boolean isBroken;

    public Usable(Integer maxDurability) {
        this.durability = maxDurability;
        this.maxDurability = maxDurability;
        this.isBroken = false;
    }

    @Override
    public void use() {
        durability--;
        if(durability <= 0) {
            isBroken = true;
        }
    }

    @Override
    public void repair() {
        durability = maxDurability;
    }

    @Override
    public Boolean isBroken() {
        return isBroken;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Physical state:");

        if(isBroken) {
            sb.append("\tBROKEN");
        } else {
            sb.append("\tNOT BROKEN");
        }

        return sb.toString();
    }
}
