package cz.cvut.fel.smarthome.model.entities.auxiliary;

import cz.cvut.fel.smarthome.model.entities.AbstractEntity;
import cz.cvut.fel.smarthome.model.entities.auxiliary.state.AuxiliaryState;
import cz.cvut.fel.smarthome.model.entities.auxiliary.state.AvailableAuxiliaryState;
import cz.cvut.fel.smarthome.model.entities.location.Location;
import cz.cvut.fel.smarthome.model.entities.location.LocationType;
import cz.cvut.fel.smarthome.model.interfaces.ILocateable;
import cz.cvut.fel.smarthome.model.interfaces.IUseable;

public class Auxiliary extends AbstractEntity<String> implements IUseable, ILocateable {

    private final AuxiliaryType destiny;
    private String location;
    private final String preferedLocation;
    private Integer scratchesNumber;
    transient private AuxiliaryState state;

    public Auxiliary(String name, AuxiliaryType destinyType, String location) {
        super(name);
        this.destiny = destinyType;
        this.scratchesNumber = 0;
        this.state = new AvailableAuxiliaryState(this);
        this.location = location;
        this.preferedLocation = location;
    }

    public void setState(AuxiliaryState state) {
        this.state = state;
    }

    public Integer getScratchesNumber() {
        return scratchesNumber;
    }

    public AuxiliaryType getDestiny() {
        return destiny;
    }

    public void locateBack() {
        location = preferedLocation;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
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
    public void misuse() {
        scratchesNumber++;
    }

    @Override
    public Boolean isAvailable() {
        return state.isAvailable();
    }


}
