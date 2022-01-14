package cz.cvut.fel.smarthome.service;

import cz.cvut.fel.smarthome.locator.Locator;
import cz.cvut.fel.smarthome.model.actor.person.Person;
import cz.cvut.fel.smarthome.model.auxiliary.Auxiliary;
import cz.cvut.fel.smarthome.model.auxiliary.AuxiliaryType;
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

    public void goSport(String personName) {
        Optional<Person> tempPer = personRepo.find(personName);
        Optional<Auxiliary> tempAux = auxiliaryRepo.findFirstByDestinyAndByAvailable(AuxiliaryType.SPORT);

        if(tempAux.isPresent() && tempPer.isPresent()) {
            tempPer.get().goSport(tempAux.get());
            locator.kick(tempPer.get());
        }
    }

}
