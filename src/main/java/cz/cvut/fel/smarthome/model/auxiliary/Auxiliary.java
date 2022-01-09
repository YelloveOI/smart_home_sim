package cz.cvut.fel.smarthome.model.auxiliary;

import cz.cvut.fel.smarthome.model.auxiliary.state.AuxiliaryState;
import cz.cvut.fel.smarthome.model.auxiliary.state.AvailableAuxiliaryState;

public class Auxiliary implements IUse {

    private final String name;
    private final AuxiliaryType destiny;
    private Integer scratchesNumber;
    private AuxiliaryState state;

    public Auxiliary(String name, AuxiliaryType destinyType) {
        this.name = name;
        this.destiny = destinyType;
        this.scratchesNumber = 0;
        this.state = new AvailableAuxiliaryState(this);
    }

    public void setState(AuxiliaryState state) {
        this.state = state;
    }

    public Integer getScratchesNumber() {
        return scratchesNumber;
    }

    public String getName() {
        return name;
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
}
