package cz.cvut.fel.smarthome.model.entities.auxiliary.state;

import cz.cvut.fel.smarthome.model.entities.auxiliary.Auxiliary;
import cz.cvut.fel.smarthome.model.event.EventProcessor;
import cz.cvut.fel.smarthome.model.event.event_context.AuxiliaryEventContext;

public class AvailableAuxiliaryState extends AuxiliaryState {

    public AvailableAuxiliaryState(Auxiliary auxiliary) {
        super(auxiliary);
    }

    @Override
    public Boolean startUse() {
        auxiliary.setState(new UnavailableAuxiliaryState(auxiliary));
        EventProcessor.getEvent(AuxiliaryEventContext.startUse(auxiliary));
        return true;
    }

    @Override
    public void stopUse() {
        EventProcessor.getEvent(AuxiliaryEventContext.stopUse(auxiliary));
    }

    @Override
    public Boolean isAvailable() {
        return true;
    }
}
