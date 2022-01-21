package cz.cvut.fel.smarthome.service;

import cz.cvut.fel.smarthome.model.entities.AbstractEntity;
import cz.cvut.fel.smarthome.model.entities.person.Person;
import cz.cvut.fel.smarthome.model.entities.pet.Pet;
import cz.cvut.fel.smarthome.model.entities.auxiliary.Auxiliary;
import cz.cvut.fel.smarthome.model.entities.device.Device;
import cz.cvut.fel.smarthome.model.entities.location.House;
import cz.cvut.fel.smarthome.model.entities.location.Location;
import cz.cvut.fel.smarthome.repository.interfaces.HouseRepository;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;


public class Locator {

    @Inject
    private HouseRepository houseRepository;
    private final Map<AbstractEntity, Location> entityMap;

    public Locator() {
        this.entityMap = new ConcurrentHashMap<>();
    }

    public Boolean locateAuxiliary(String houseName, Auxiliary auxiliary, String locationName) {
        House house = houseRepository.find(houseName).get();
        Optional<Location> tempLoc = house.findByName(locationName);
        if(tempLoc.isPresent()) {
            if(entityMap.containsKey(auxiliary)) {
                entityMap.replace(auxiliary, tempLoc.get());
            } else {
                entityMap.put(auxiliary, tempLoc.get());
            }
            houseRepository.update(house);

            return true;
        }

        return false;
    }

    public Boolean locateDevice(String houseName, Device device, String locationName) {
        House house = houseRepository.find(houseName).get();
        Optional<Location> tempLoc = house.findByName(locationName);
        if(tempLoc.isPresent()) {
            if(entityMap.containsKey(device)) {
                entityMap.replace(device, tempLoc.get());
            } else {
                entityMap.put(device, tempLoc.get());
            }
            houseRepository.update(house);

            return true;
        }

        return false;
    }

    public Boolean locatePerson(String houseName, Person person, String locationName) {
        House house = houseRepository.find(houseName).get();
        Optional<Location> tempLoc = house.findByName(locationName);
        if(tempLoc.isPresent()) {
            if(entityMap.containsKey(person)) {
                entityMap.replace(person, tempLoc.get());
            } else {
                entityMap.put(person, tempLoc.get());
            }
            houseRepository.update(house);

            return true;
        }

        return false;
    }

    public Boolean locatePet(String houseName, Pet pet, String locationName) {
        House house = houseRepository.find(houseName).get();
        Optional<Location> tempLoc = house.findByName(locationName);
        if(tempLoc.isPresent()) {
            if(entityMap.containsKey(pet)) {
                entityMap.replace(pet, tempLoc.get());
            } else {
                entityMap.put(pet, tempLoc.get());
            }
            houseRepository.update(house);

            return true;
        }

        return false;
    }

    public Boolean locatePerson(String houseName, Person person) {
        return locatePerson(houseName, person, "HALL");
    }

    public Boolean locatePet(String houseName, Pet pet) {
        return locatePet(houseName, pet, "HALL");
    }

    public Boolean kick(String houseName, Person person) {
        return locatePerson(houseName, person, "OUTSIDE");
    }

}
