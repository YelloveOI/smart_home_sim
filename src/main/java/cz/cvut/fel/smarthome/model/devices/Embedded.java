package cz.cvut.fel.smarthome.model.devices;

import cz.cvut.fel.smarthome.model.surfaces.InstallationSurface;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

public class Embedded extends Device {

    @Inject(beanType = "prototype")
    private InstallationSurface embeddingPosition;

    public Embedded() {
    }

    public InstallationSurface getEmbeddingPosition() {
        return embeddingPosition;
    }

    public Embedded setEmbeddingPosition(InstallationSurface embeddingPosition) {
        this.embeddingPosition = embeddingPosition;
        return this;
    }
}
