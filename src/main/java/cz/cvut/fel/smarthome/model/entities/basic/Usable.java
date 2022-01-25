package cz.cvut.fel.smarthome.model.entities.basic;

import cz.cvut.fel.smarthome.model.entities.basic.interfaces.IUsable;

public class Usable implements IUsable {

    private final Integer maxDurability;
    private Integer durability;
    private Boolean isAvailable;
    private Boolean isBroken;

    public Usable(Integer maxDurability) {
        this.durability = maxDurability;
        this.maxDurability = maxDurability;
        this.isAvailable = true;
        this.isBroken = false;
    }

    @Override
    public Boolean startUse() {
        misuse();
        if(isAvailable && !isBroken) {
            isAvailable = false;
            return true;
        }
        return false;
    }

    @Override
    public void stopUse() {
        isAvailable = true;
    }

    @Override
    public void misuse() {
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
    public Boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public Boolean isBroken() {
        return isBroken;
    }
}
