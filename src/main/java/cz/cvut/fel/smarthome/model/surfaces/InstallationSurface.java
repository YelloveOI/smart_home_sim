package cz.cvut.fel.smarthome.model.surfaces;

import cz.cvut.fel.smarthome.model.devices.Device;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

import java.util.HashSet;
import java.util.Set;

public class InstallationSurface {

    @Inject(beanType = "prototype")
    private PositionClarification position;
    private Set<Device> devices;

    public InstallationSurface() {
        this.devices = new HashSet<>();
    }

    public PositionClarification getPosition() {
        return position;
    }

    public InstallationSurface setPosition(PositionClarification position) {
        this.position = position;
        return this;
    }

    public Set<Device> getDevices() {
        return devices;
    }

    public InstallationSurface setDevices(Set<Device> devices) {
        this.devices = devices;
        return this;
    }
}
