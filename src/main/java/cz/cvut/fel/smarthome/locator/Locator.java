package cz.cvut.fel.smarthome.locator;

import cz.cvut.fel.smarthome.model.AbstractEntity;
import cz.cvut.fel.smarthome.model.actor.person.Person;
import cz.cvut.fel.smarthome.model.actor.pet.Pet;
import cz.cvut.fel.smarthome.model.auxiliary.Auxiliary;
import cz.cvut.fel.smarthome.model.device.Device;
import cz.cvut.fel.smarthome.model.location.House;
import cz.cvut.fel.smarthome.model.location.Location;
import cz.cvut.fel.smarthome.repository.interfaces.AuxiliaryRepository;
import cz.cvut.fel.smarthome.repository.interfaces.DeviceRepository;
import cz.cvut.fel.smarthome.repository.interfaces.PersonRepository;
import cz.cvut.fel.smarthome.repository.interfaces.PetRepository;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;


//TODO
public class Locator {

    private final Map<AbstractEntity, Location> entityMap;
    private final House house;

    //TODO how to init
    public Locator(House house) {
        this.house = house;
        this.entityMap = new ConcurrentHashMap<>();
    }

    public Boolean locateAuxiliary(Auxiliary auxiliary, String locationName) {
        Optional<Location> tempLoc = house.findByName(locationName);
        if(tempLoc.isPresent()) {
            if(entityMap.containsKey(auxiliary)) {
                entityMap.replace(auxiliary, tempLoc.get());
            } else {
                entityMap.put(auxiliary, tempLoc.get());
            }

            return true;
        }

        return false;
    }

    public Boolean locateDevice(Device device, String locationName) {
        Optional<Location> tempLoc = house.findByName(locationName);
        if(tempLoc.isPresent()) {
            if(entityMap.containsKey(device)) {
                entityMap.replace(device, tempLoc.get());
            } else {
                entityMap.put(device, tempLoc.get());
            }

            return true;
        }

        return false;
    }

    public Boolean locatePerson(Person person, String locationName) {
        Optional<Location> tempLoc = house.findByName(locationName);
        if(tempLoc.isPresent()) {
            if(entityMap.containsKey(person)) {
                entityMap.replace(person, tempLoc.get());
            } else {
                entityMap.put(person, tempLoc.get());
            }

            return true;
        }

        return false;
    }

    public Boolean locatePet(Pet pet, String locationName) {
        Optional<Location> tempLoc = house.findByName(locationName);
        if(tempLoc.isPresent()) {
            if(entityMap.containsKey(pet)) {
                entityMap.replace(pet, tempLoc.get());
            } else {
                entityMap.put(pet, tempLoc.get());
            }

            return true;
        }

        return false;
    }

    public Boolean locatePerson(Person person) {
        return locatePerson(person, "HALL");
    }

    public Boolean locatePet(Pet pet) {
        return locatePet(pet, "HALL");
    }

    public Boolean kick(Person person) {
        return locatePerson(person, "OUTSIDE");
    }
}
