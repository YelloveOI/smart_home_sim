package cz.cvut.fel.smarthome.model.auxiliary.state;

import cz.cvut.fel.smarthome.model.auxiliary.Auxiliary;
import cz.cvut.fel.smarthome.model.event.EventProcessor;

public class AvailableAuxiliaryState extends AuxiliaryState {

    public AvailableAuxiliaryState(Auxiliary auxiliary) {
        super(auxiliary);
    }

    @Override
    public Boolean startUse() {
        auxiliary.setState(new UnavailableAuxiliaryState(auxiliary));
        //TODO
//        EventProcessor
//                .createReport(this.getClass(), auxiliary.getName(),"is used")
//                .execute();
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
