package cz.cvut.fel.smarthome.service;

import cz.cvut.fel.smarthome.model.entities.device.StorageDevice;
import cz.cvut.fel.smarthome.model.entities.person.Person;
import cz.cvut.fel.smarthome.model.entities.Auxiliary;
import cz.cvut.fel.smarthome.model.entities.pet.Pet;
import cz.cvut.fel.smarthome.model.entities.basic.interfaces.ILocateable;
import cz.cvut.fel.smarthome.repository.interfaces.*;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

import java.util.Optional;

public class PersonService {

    @Inject
    private Locator locator;
    @Inject
    private AuxiliaryRepository auxiliaryRepo;
    @Inject
    private DeviceRepository deviceRepo;
    @Inject
    private PersonRepository personRepo;
    @Inject
    private PetRepository petRepo;
    @Inject
    private StorageDeviceRepository storageRepo;

    public PersonService() {
    }

    public void goSport(String personName) {
        Optional<Person> tempPer = personRepo.find(personName);
        Optional<Auxiliary> tempAux = auxiliaryRepo.findFirstByDestinyAndByAvailable(AuxiliaryType.SPORT);

        if(tempAux.isPresent() && tempPer.isPresent()) {
            if(!tempPer.get().isFree()) {
                getFree(personName);
            }
            tempPer.get().becomeBusy(tempAux.get());
            tempAux.get().startUse();

            locator.delocate(tempPer.get());
            locator.delocate(tempAux.get());

            tempPer.get().setLocation("OUTSIDE");
            tempAux.get().setLocation("OUTSIDE");

            locator.locate(tempAux.get());
            locator.locate(tempPer.get());

            auxiliaryRepo.update(tempAux.get());
            personRepo.update(tempPer.get());
        }
    }

    public void goWork(String personName) {
        Optional<Person> tempPer = personRepo.find(personName);
        Optional<Auxiliary> tempAux = auxiliaryRepo.findFirstByDestinyAndByAvailable(AuxiliaryType.WORK);

        if(tempAux.isPresent() && tempPer.isPresent()) {
            if(!tempPer.get().isFree()) {
                getFree(personName);
            }
            tempPer.get().becomeBusy(tempAux.get());
            tempAux.get().startUse();

            locator.delocate(tempPer.get());
            locator.delocate(tempAux.get());

            tempPer.get().setLocation("OUTSIDE");
            tempAux.get().setLocation("OUTSIDE");

            locator.locate(tempAux.get());
            locator.locate(tempPer.get());

            auxiliaryRepo.update(tempAux.get());
            personRepo.update(tempPer.get());
        }
    }

    public void goProcrastinate(String personName) {
        Optional<Person> tempPer = personRepo.find(personName);
        Optional<DeviceOLD> tempDev = deviceRepo.findRandomByIsAvailable();

        if(tempPer.isPresent() && tempDev.isPresent()) {
            if(!tempPer.get().isFree()) {
                getFree(personName);
            }
            tempPer.get().becomeBusy(tempDev.get());
            tempDev.get().startUse();

            locator.delocate(tempPer.get());
            tempPer.get().setLocation(tempDev.get().getLocation());
            locator.locate(tempPer.get());

            deviceRepo.update(tempDev.get());
            personRepo.update(tempPer.get());
        }
    }

    public void getFree(String personName) {
        Optional<Person> tempPer = personRepo.find(personName);

        if(tempPer.isPresent()) {
            locator.delocate(tempPer.get());
            locator.delocate((ILocateable) tempPer.get().getInUse());

            tempPer.get().getInUse().stopUse();
            tempPer.get().setLocation("HALL");

            locator.locate(tempPer.get());
            locator.locate((ILocateable) tempPer.get().getInUse());

            tempPer.get().getFree();

            personRepo.update(tempPer.get());
        }
    }

    public void feedPet(String petName)  {
        Optional<Person> tempPer = personRepo.findFirstByIsFree();
        Optional<Pet> tempPet = petRepo.find(petName);

        if(tempPer.isPresent() && tempPet.isPresent()) {
            Optional<StorageDevice> foodStorage = storageRepo.findRandomByStorageDeviceType(StorageDeviceType.FRIDGE);

            if(foodStorage.isPresent()) {
                locator.delocate(tempPer.get());
                tempPer.get().setLocation(foodStorage.get().getLocation());
                locator.locate(tempPer.get());
                if(foodStorage.get().get()) {
                    locator.delocate(tempPer.get());
                    tempPer.get().setLocation(tempPet.get().getLocation());
                    locator.locate(tempPer.get());
                    tempPet.get().feed();
                } else {
                    //TODO go to shop;
                }
            }
        }
    }

}
