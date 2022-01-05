package cz.cvut.fel.smarthome.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Floor {

    private String name;
    private Integer number;
    private Set<Place> places;

    public Floor() {
        this.places = new HashSet<>();
    }

    public Integer getNumber() {
        return number;
    }

    public Floor setNumber(Integer number) {
        this.number = number;
        return this;
    }

    public String getName() {
        return name;
    }

    public Floor setName(String name) {
        this.name = name;
        return this;
    }

    public Set<Place> getPlaces() {
        return places;
    }

    public Floor setPlaces(Set<Place> places) {
        this.places = places;
        return this;
    }

    public Floor addPlace(Place place) {
        places.add(place);
        return this;
    }

    public Floor removePlace(Place place) {
        places.remove(place);
        return this;
    }

    @Override
    public String toString() {
        return "Floor{" + "\n" +
                "\t\tname='" + name + '\'' + ",\n" +
                "\t\tnumber=" + number + ",\n" +
                "\t\tplaces=" + places + ",\n" +
                '}';
    }
}
