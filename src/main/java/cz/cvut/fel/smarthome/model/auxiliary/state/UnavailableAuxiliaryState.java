package cz.cvut.fel.smarthome.model.auxiliary.state;

import cz.cvut.fel.smarthome.model.auxiliary.Auxiliary;
import cz.cvut.fel.smarthome.model.event.EventChannelContext;

public class UnavailableAuxiliaryState extends AuxiliaryState {

    public UnavailableAuxiliaryState(Auxiliary auxiliary) {
        super(auxiliary);
    }

    @Override
    public Boolean startUse() {
        EventChannelContext
                .createReport(this.getClass(), auxiliary.getName(),"is unavailable")
                .execute();
        return false;
    }

    @Override
    public void stopUse() {
        auxiliary.setState(new AvailableAuxiliaryState(auxiliary));
        EventChannelContext
                .createReport(this.getClass(), auxiliary.getName(),"is not used anymore")
                .execute();
    }

    @Override
    public Boolean isAvailable() {
        return false;
    }
}
