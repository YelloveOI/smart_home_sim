package cz.cvut.fel.smarthome.model.entities.auxiliary.state;

import cz.cvut.fel.smarthome.model.entities.auxiliary.Auxiliary;

public class AvailableAuxiliaryState extends AuxiliaryState {

    public AvailableAuxiliaryState(Auxiliary auxiliary) {
        super(auxiliary);
    }

    @Override
    public Boolean startUse() {
        auxiliary.setState(new UnavailableAuxiliaryState(auxiliary));
        return true;
    }

    @Override
    public void stopUse() {
    }

    @Override
    public Boolean isAvailable() {
        return true;
    }
}
