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

    @Inject
    private AuxiliaryRepository auxiliaryRepo;
    @Inject
    private DeviceRepository deviceRepo;
    @Inject
    private PersonRepository personRepo;
    @Inject
    private PetRepository petRepo;

    private final Map<AbstractEntity, Location> entityMap;
    private final House house;

    public Locator(House house) {
        this.house = house;
        this.entityMap = new ConcurrentHashMap<>();
    }

    public Boolean locateAuxiliary(String auxiliaryName, String locationName) {
        Optional<Auxiliary> tempAux = auxiliaryRepo.find(auxiliaryName);
        Optional<Location> tempLoc = house.findByName(locationName);
        if(tempAux.isPresent() && tempLoc.isPresent()) {
            if(entityMap.containsKey(tempAux.get())) {
                entityMap.replace(tempAux.get(), tempLoc.get());
            } else {
                entityMap.put(tempAux.get(), tempLoc.get());
            }

            return true;
        }

        return false;
    }

    public Boolean locateDevice(String deviceName, String locationName) {
        Optional<Device> tempDev = deviceRepo.find(deviceName);
        Optional<Location> tempLoc = house.findByName(locationName);
        if(tempDev.isPresent() && tempLoc.isPresent()) {
            if(entityMap.containsKey(tempDev.get())) {
                entityMap.replace(tempDev.get(), tempLoc.get());
            } else {
                entityMap.put(tempDev.get(), tempLoc.get());
            }

            return true;
        }

        return false;
    }

    public Boolean locatePerson(String personName, String locationName) {
        Optional<Person> tempPer = personRepo.find(personName);
        Optional<Location> tempLoc = house.findByName(locationName);
        if(tempPer.isPresent() && tempLoc.isPresent()) {
            if(entityMap.containsKey(tempPer.get())) {
                entityMap.replace(tempPer.get(), tempLoc.get());
            } else {
                entityMap.put(tempPer.get(), tempLoc.get());
            }

            return true;
        }

        return false;
    }

    public Boolean locatePet(String petName, String locationName) {
        Optional<Pet> tempPet = petRepo.find(petName);
        Optional<Location> tempLoc = house.findByName(locationName);
        if(tempPet.isPresent() && tempLoc.isPresent()) {
            if(entityMap.containsKey(tempPet.get())) {
                entityMap.replace(tempPet.get(), tempLoc.get());
            } else {
                entityMap.put(tempPet.get(), tempLoc.get());
            }

            return true;
        }

        return false;
    }

    public Boolean locatePerson(String personName) {
        Optional<Person> tempPer = personRepo.find(personName);
        Optional<Location> tempLoc = house.findByName("HALL");
        if(tempPer.isPresent()) {
            if(entityMap.containsKey(tempPer.get())) {
                entityMap.replace(tempPer.get(), tempLoc.get());
            } else {
                entityMap.put(tempPer.get(), tempLoc.get());
            }

            return true;
        }

        return false;
    }

    public Boolean locatePet(String petName) {
        Optional<Pet> tempPet = petRepo.find(petName);
        Optional<Location> tempLoc = house.findByName("HALL");
        if(tempPet.isPresent()) {
            if(entityMap.containsKey(tempPet.get())) {
                entityMap.replace(tempPet.get(), tempLoc.get());
            } else {
                entityMap.put(tempPet.get(), tempLoc.get());
            }

            return true;
        }

        return false;
    }

    public Boolean kick(String personName) {
        return locatePerson(personName, "OUTSIDE");
    }
}
