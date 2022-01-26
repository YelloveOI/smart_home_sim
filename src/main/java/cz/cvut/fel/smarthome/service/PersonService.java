package cz.cvut.fel.smarthome.service;

import cz.cvut.fel.smarthome.model.entities.Command;
import cz.cvut.fel.smarthome.model.entities.Order;
import cz.cvut.fel.smarthome.model.entities.auxiliary.AbstractAuxiliary;
import cz.cvut.fel.smarthome.model.entities.device.AbstractUsableDevice;
import cz.cvut.fel.smarthome.model.entities.movable.AbstractAlive;
import cz.cvut.fel.smarthome.model.entities.movable.Person;
import cz.cvut.fel.smarthome.repository.interfaces.*;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

import java.util.Optional;

public class PersonService {

    @Inject
    private AliveRepository aliveRepository;
    @Inject
    private StorageDeviceRepository storageDeviceRepository;
    @Inject
    private UsableDeviceRepository usableDeviceRepository;
    @Inject
    private SimpleDeviceRepository simpleDeviceRepository;
    @Inject
    private AuxiliaryRepository auxiliaryRepository;

    public PersonService() {
    }

    public Boolean goWork(String personName, String carName) {
        Optional<AbstractAlive> person = aliveRepository.find(personName);
        Optional<AbstractAuxiliary> car = auxiliaryRepository.find(carName);

        if(person.isEmpty() || car.isEmpty()) {
            //TODO exception
            return false;
        }

        //TODO locator's job
        person.get().order(Order.WORK);
        car.get().use();

        return true;
    }

    public Boolean goSport(String personName, String sportInventoryName) {
        Optional<AbstractAlive> person = aliveRepository.find(personName);
        Optional<AbstractAuxiliary> sportInventory = auxiliaryRepository.find(sportInventoryName);

        if(person.isEmpty() || sportInventory.isEmpty()) {
            //TODO exception
            return false;
        }

        //TODO locator's job
        person.get().order(Order.SPORT);
        sportInventory.get().use();

        return true;
    }

    public Boolean goProcrastinate(String personName, String usableDeviceName) {
        Optional<AbstractAlive> person = aliveRepository.find(personName);
        Optional<AbstractUsableDevice> usableDevice = usableDeviceRepository.find(usableDeviceName);

        if(person.isEmpty() || usableDevice.isEmpty()) {
            //TODO exception
            return false;
        }

        //TODO locator's job
        person.get().order(Order.BUSY_5);
        usableDevice.get().command(Command.ON);
        usableDevice.get().command(Command.PLAY);

        return true;
    }

    public Boolean repairUsable(String personName, String usableName) {
        //TODO
        return false;
    }

}
