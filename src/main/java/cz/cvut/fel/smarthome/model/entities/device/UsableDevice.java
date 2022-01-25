package cz.cvut.fel.smarthome.model.entities.device;

import cz.cvut.fel.smarthome.model.entities.basic.Usable;
import cz.cvut.fel.smarthome.model.entities.basic.interfaces.IUsable;

public class UsableDevice extends DeviceOLD implements IUsable {

    private final Usable usable;
    //TODO manual, repair mech

    public UsableDevice(String name, Double activeConsumption, String preferredLocation, Integer durability) {
        super(name, activeConsumption, preferredLocation);
        this.usable = new Usable(durability);
    }

    @Override
    public Boolean isAvailable() {
        return usable.isAvailable() && isActive();
    }

    @Override
    public Boolean isBroken() {
        return usable.isBroken();
    }

    @Override
    public Boolean startUse() {
        if(isActive()) {
            return usable.startUse();
        }

        return false;
    }

    @Override
    public void stopUse() {
        usable.stopUse();
    }

    @Override
    public void misuse() {
        usable.misuse();
    }


}
