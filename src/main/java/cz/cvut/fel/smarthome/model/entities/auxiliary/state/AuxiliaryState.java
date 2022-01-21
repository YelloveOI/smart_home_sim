package cz.cvut.fel.smarthome.model.entities.auxiliary.state;

import cz.cvut.fel.smarthome.model.entities.auxiliary.Auxiliary;

public abstract class AuxiliaryState {

    protected final Auxiliary auxiliary;

    public AuxiliaryState(Auxiliary auxiliary) {
        this.auxiliary = auxiliary;
    }

    abstract public Boolean startUse();
    abstract public void stopUse();
    abstract public Boolean isAvailable();

}
