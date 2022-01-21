package cz.cvut.fel.smarthome.service;

import cz.cvut.fel.smarthome.model.action.TurnOnAction;
import cz.cvut.fel.smarthome.model.entities.person.Person;
import cz.cvut.fel.smarthome.model.entities.auxiliary.Auxiliary;
import cz.cvut.fel.smarthome.model.entities.auxiliary.AuxiliaryType;
import cz.cvut.fel.smarthome.model.entities.device.Device;
import cz.cvut.fel.smarthome.model.interfaces.ILocateable;
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
        Optional<Device> tempDev = deviceRepo.findFirstByIsAvailable();

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
            tempPer.get().getInUse().stopUse();
            locator.delocate(tempPer.get());
            locator.delocate((ILocateable) tempPer.get().getInUse());
            tempPer.get().setLocation("HALL");
            ((ILocateable) tempPer.get().getInUse()).locateBack;
            locator.locate(tempPer.get());
            tempPer.get().getFree();
            personRepo.update(tempPer.get());
        }
    }

}
