package cz.cvut.fel.smarthome.model.entities.auxiliary.state;

import cz.cvut.fel.smarthome.model.entities.auxiliary.Auxiliary;
import cz.cvut.fel.smarthome.model.event.EventProcessor;
import cz.cvut.fel.smarthome.model.event.event_context.AuxiliaryEventContext;

public class UnavailableAuxiliaryState extends AuxiliaryState {

    public UnavailableAuxiliaryState(Auxiliary auxiliary) {
        super(auxiliary);
    }

    @Override
    public Boolean startUse() {
        EventProcessor.getEvent(AuxiliaryEventContext.imUnavailable(auxiliary));
        return false;
    }

    @Override
    public void stopUse() {
        auxiliary.setState(new AvailableAuxiliaryState(auxiliary));
        EventProcessor.getEvent(AuxiliaryEventContext.stopUse(auxiliary));
    }

    @Override
    public Boolean isAvailable() {
        return false;
    }
}
