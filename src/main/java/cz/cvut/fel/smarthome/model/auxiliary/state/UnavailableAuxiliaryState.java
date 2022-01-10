package cz.cvut.fel.smarthome.model.auxiliary.state;

import cz.cvut.fel.smarthome.model.auxiliary.Auxiliary;
import cz.cvut.fel.smarthome.model.event.ReportContext;

public class UnavailableAuxiliaryState extends AuxiliaryState {

    public UnavailableAuxiliaryState(Auxiliary auxiliary) {
        super(auxiliary);
    }

    @Override
    public Boolean startUse() {
        ReportContext
                .createReportEvent(this.getClass(), auxiliary.getName(),"is unavailable")
                .execute();
        return false;
    }

    @Override
    public void stopUse() {
        auxiliary.setState(new AvailableAuxiliaryState(auxiliary));
        ReportContext
                .createReportEvent(this.getClass(), auxiliary.getName(),"is not used anymore")
                .execute();
    }

    @Override
    public Boolean isAvailable() {
        return false;
    }
}
