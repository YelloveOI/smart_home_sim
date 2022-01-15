package cz.cvut.fel.smarthome.service;

import cz.cvut.fel.smarthome.model.actor.action.TurnOnAction;
import cz.cvut.fel.smarthome.model.actor.person.Person;
import cz.cvut.fel.smarthome.model.auxiliary.Auxiliary;
import cz.cvut.fel.smarthome.model.auxiliary.AuxiliaryType;
import cz.cvut.fel.smarthome.model.device.Device;
import cz.cvut.fel.smarthome.repository.interfaces.AuxiliaryRepository;
import cz.cvut.fel.smarthome.repository.interfaces.DeviceRepository;
import cz.cvut.fel.smarthome.repository.interfaces.PersonRepository;
import cz.cvut.fel.smarthome.repository.interfaces.PetRepository;
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

    public PersonService() {
    }

    public void goSport(String houseName, String personName) {
        Optional<Person> tempPer = personRepo.find(personName);
        Optional<Auxiliary> tempAux = auxiliaryRepo.findFirstByDestinyAndByAvailable(AuxiliaryType.SPORT);

        if(tempAux.isPresent() && tempPer.isPresent()) {
            tempPer.get().goSport(tempAux.get());
            locator.kick(houseName, tempPer.get());
            personRepo.update(tempPer.get());
        }
    }

    public void goWork(String houseName, String personName) {
        Optional<Person> tempPer = personRepo.find(personName);
        Optional<Auxiliary> tempAux = auxiliaryRepo.findFirstByDestinyAndByAvailable(AuxiliaryType.WORK);

        if(tempAux.isPresent() && tempPer.isPresent()) {
            tempPer.get().goWork(tempAux.get());
            locator.kick(houseName, tempPer.get());
            personRepo.update(tempPer.get());
        }
    }

    public void goProcrastinate(String personName) {
        Optional<Person> tempPer = personRepo.find(personName);
        Optional<Device> tempDev = deviceRepo.findFirstByIsAvailable();

        if(tempPer.isPresent()) {
            if(tempDev.isEmpty()) {
                tempDev = deviceRepo.findRandom();
                tempPer.get().act(new TurnOnAction(tempDev.get()));
            }
            tempPer.get().goProcrastinate(tempDev.get());
            personRepo.update(tempPer.get());
        }
    }

    public void getFreeFromActivity(String houseName, String personName) {
        Optional<Person> tempPer = personRepo.find(personName);

        if(tempPer.isPresent()) {
            tempPer.get().getFreeFromActivity();
            locator.locatePerson(houseName, tempPer.get());
            personRepo.update(tempPer.get());
        }
    }

}
