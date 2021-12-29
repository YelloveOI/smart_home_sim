package cz.cvut.fel.smarthome.model;

import cz.cvut.fel.smarthome.model.surfaces.InstallationSurface;

import java.util.List;

public class Place {

    private List<InstallationSurface> surfaces;
    private String name;

    public Place() {
    }

    public List<InstallationSurface> getSurfaces() {
        return surfaces;
    }

    public void setSurfaces(List<InstallationSurface> surfaces) {
        this.surfaces = surfaces;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
