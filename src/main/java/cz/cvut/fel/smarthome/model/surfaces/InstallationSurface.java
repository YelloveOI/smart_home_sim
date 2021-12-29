package cz.cvut.fel.smarthome.model.surfaces;

import cz.cvut.fel.smarthome.model.devices.Device;

import java.util.Set;

public class InstallationSurface {

    private PositionClarification position;
    private Set<Device> devices;

    public InstallationSurface() {
    }

    public PositionClarification getPosition() {
        return position;
    }

    public void setPosition(PositionClarification position) {
        this.position = position;
    }

    public Set<Device> getDevices() {
        return devices;
    }

    public void setDevices(Set<Device> devices) {
        this.devices = devices;
    }
}
