package cz.cvut.fel.smarthome.model;

import java.util.List;

public class Floor {

    private String name;
    private List<Place> places;

    public Floor() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }
}
