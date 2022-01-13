package cz.cvut.fel.smarthome.model.auxiliary;

import com.google.gson.annotations.Expose;
import cz.cvut.fel.smarthome.model.AbstractEntity;
import cz.cvut.fel.smarthome.model.auxiliary.state.AuxiliaryState;
import cz.cvut.fel.smarthome.model.auxiliary.state.AvailableAuxiliaryState;
import cz.cvut.fel.smarthome.model.event.ReportContext;
import cz.cvut.fel.smarthome.model.event.PlainEvent;
import cz.cvut.fel.smarthome.model.interfaces.IUseable;

public class Auxiliary extends AbstractEntity implements IUseable {

    private final AuxiliaryType destiny;
    private Integer scratchesNumber;
    transient private AuxiliaryState state;

    public Auxiliary(String name, AuxiliaryType destinyType) {
        super(name);
        this.destiny = destinyType;
        this.scratchesNumber = 0;
        this.state = new AvailableAuxiliaryState(this);
    }

    public void setState(AuxiliaryState state) {
        this.state = state;
        ReportContext
                .createReportEvent(this.getClass(), name, " state changed to - " + state.getClass().getSimpleName());
    }

    public Integer getScratchesNumber() {
        return scratchesNumber;
    }

    public AuxiliaryType getDestiny() {
        return destiny;
    }

    @Override
    public Boolean startUse() {
        return state.startUse();
    }

    @Override
    public void stopUse() {
        state.stopUse();
    }

    @Override
    public void badUse() {
        scratchesNumber++;
    }

    @Override
    public Boolean isAvailable() {
        return state.isAvailable();
    }

}
