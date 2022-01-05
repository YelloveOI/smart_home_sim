package cz.cvut.fel.smarthome.model;

import cz.cvut.fel.smarthome.model.surfaces.InstallationSurface;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Place {

    private List<InstallationSurface> surfaces;
    private String name;

    public Place() {
        this.surfaces = new ArrayList<>();
    }

    public List<InstallationSurface> getSurfaces() {
        return surfaces;
    }

    public Place setSurfaces(List<InstallationSurface> surfaces) {
        this.surfaces = surfaces;
        return this;
    }

    public Place addSurface(InstallationSurface surface) {
        surfaces.add(surface);
        return this;
    }

    public Place removeSurface(InstallationSurface surface) {
        surfaces.remove(surface);
        return this;
    }

    public String getName() {
        return name;
    }

    public Place setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Place place = (Place) o;

        if (!Objects.equals(surfaces, place.surfaces)) return false;
        return Objects.equals(name, place.name);
    }

    @Override
    public int hashCode() {
        int result = surfaces != null ? surfaces.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Place{" +
                "surfaces=" + surfaces +
                ", name='" + name + '\'' +
                '}';
    }
}
