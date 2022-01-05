package cz.cvut.fel.smarthome.model;

import cz.cvut.fel.smarthome.model.moveables.Person;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Home {

    private String name;

    @Inject
    private Address address;

    private List<Floor> floors;

    private Set<Person> owners;

    public Home() {
        this.floors = new ArrayList<>();
        this.owners = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Home setName(String name) {
        this.name = name;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public Home setAddress(Address address) {
        this.address = address;
        return this;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public Home setFloors(List<Floor> floors) {
        this.floors = floors;
        return this;
    }

    public Home addFloor(Floor floor) {
        floors.add(floor);
        return this;
    }

    public Home removeFloor(Floor floor) {
        floors.remove(floor);
        return this;
    }

    public Set<Person> getOwners() {
        return owners;
    }

    public Home setOwners(Set<Person> owners) {
        this.owners = owners;
        return this;
    }

    public Home addOwner(Person newOwner) {
        owners.add(newOwner);
        return this;
    }

    public Home removeOwner(Person ownerToRemove) {
        owners.remove(ownerToRemove);
        return this;
    }

    @Override
    public String toString() {
        return "Home{\n" +
                "\tname='" + name + '\'' + ",\n" +
                "\taddress=" + address + ",\n" +
                "\tfloors=" + floors + ",\n" +
                "\towners=" + owners + ",\n" +
                '}';
    }
}
