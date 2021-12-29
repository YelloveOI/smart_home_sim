package cz.cvut.fel.smarthome.model.devices;

import cz.cvut.fel.smarthome.model.surfaces.InstallationSurface;

public class Embeded extends Device {

    private InstallationSurface embedingPosition;

    public Embeded() {
    }

    public InstallationSurface getEmbedingPosition() {
        return embedingPosition;
    }

    public void setEmbedingPosition(InstallationSurface embedingPosition) {
        this.embedingPosition = embedingPosition;
    }
}
