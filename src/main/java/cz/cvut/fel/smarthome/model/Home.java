package cz.cvut.fel.smarthome.model;

import cz.cvut.fel.smarthome.model.moveables.Person;

import java.util.List;
import java.util.Set;

public class Home {

    private String name;
    private Address address;
    private List<Floor> floors;
    private Set<Person> owners;

    public Home() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public Set<Person> getOwners() {
        return owners;
    }

    public void setOwners(Set<Person> owners) {
        this.owners = owners;
    }

    public void addOwner(Person newOwner) {
        owners.add(newOwner);
    }

    public void removeOwner(Person ownerToRemove) {
        owners.remove(ownerToRemove);
    }
}
