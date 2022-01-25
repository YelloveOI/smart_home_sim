package cz.cvut.fel.smarthome.model.entities.device;

import cz.cvut.fel.smarthome.model.entities.AbstractEntity;
import cz.cvut.fel.smarthome.model.entities.basic.Locatable;
import cz.cvut.fel.smarthome.model.entities.basic.interfaces.ILocateable;

public abstract class DeviceOLD extends AbstractEntity<String> implements ILocateable {

    private final Double activeConsumption;
    private final Locatable locatable;
    private Boolean isActive;

    public DeviceOLD(
            String name,
            Double activeConsumption,
            String preferredLocation
    ) {
        super(name);
        this.locatable = new Locatable(preferredLocation);
        this.activeConsumption = activeConsumption;
        this.isActive = false;
    }

    @Override
    public String getLocation() {
        return locatable.getLocation();
    }

    @Override
    public void setLocation(String location) {
        locatable.setLocation(location);
    }

    @Override
    public void locateBack() {
        locatable.locateBack();
    }

    public void powerButton() {
        isActive = !isActive;
    }

    public Double getCurrentConsumption() {
        return isActive ? activeConsumption : 0d;
    }

}
