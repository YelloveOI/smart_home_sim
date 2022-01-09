package cz.cvut.fel.smarthome.model.auxiliary.state;

import cz.cvut.fel.smarthome.model.auxiliary.Auxiliary;

public class UnavailableAuxiliaryState extends AuxiliaryState {

    public UnavailableAuxiliaryState(Auxiliary auxiliary) {
        super(auxiliary);
    }

    @Override
    public Boolean startUse() {
        return false;
    }

    @Override
    public void stopUse() {
        auxiliary.setState(new AvailableAuxiliaryState(auxiliary));
    }

}
