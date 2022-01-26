package cz.cvut.fel.smarthome.service;

import cz.cvut.fel.smarthome.model.entities.auxiliary.Car;
import cz.cvut.fel.smarthome.model.entities.auxiliary.SportInventory;
import cz.cvut.fel.smarthome.model.entities.device.Blind;
import cz.cvut.fel.smarthome.model.entities.device.DaylightSensor;
import cz.cvut.fel.smarthome.model.entities.device.Fridge;
import cz.cvut.fel.smarthome.model.entities.device.TV;
import cz.cvut.fel.smarthome.model.entities.location.House;
import cz.cvut.fel.smarthome.model.entities.location.Location;
import cz.cvut.fel.smarthome.model.entities.location.LocationType;
import cz.cvut.fel.smarthome.model.entities.movable.Person;
import cz.cvut.fel.smarthome.repository.interfaces.*;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

public class Configurator {

    @Inject
    private AliveRepository aliveRepository;
    @Inject
    private HouseRepository houseRepository;
    @Inject
    private LocationRepository locationRepository;
    @Inject
    private SimpleDeviceRepository simpleDeviceRepository;
    @Inject
    private StorageDeviceRepository storageDeviceRepository;
    @Inject
    private UsableDeviceRepository usableDeviceRepository;
    @Inject
    private AuxiliaryRepository auxiliaryRepository;

    public void config1() {
        Person p1 = new Person("Ivan", "room1");
        Person p2 = new Person("Robert", "room2");
        Person p3 = new Person("Kate", "room3");
        Person p4 = new Person("Strasidlo", "room1");
        aliveRepository.create(p1);
        aliveRepository.create(p2);
        aliveRepository.create(p3);
        aliveRepository.create(p4);

        House house = new House("HOUSE", 2, 3, 1, 0, embeddedMap, locations);
        houseRepository.create(house);

        Blind b1 = new Blind("b1",  5.2);
        Blind b2 = new Blind("b2",  5.2);
        Blind b3 = new Blind("b3",  5.2);
        Blind b4 = new Blind("b4",  5.2);
        DaylightSensor ds1 = new DaylightSensor("ds1", "room1", 1.2);
        simpleDeviceRepository.create(b1);
        simpleDeviceRepository.create(b2);
        simpleDeviceRepository.create(b3);
        simpleDeviceRepository.create(b4);
        simpleDeviceRepository.create(ds1);

        Fridge f1 = new Fridge("f1", "room2", 20.1);
        storageDeviceRepository.create(f1);

        TV tv1 = new TV("tv1", 12.4);
        TV tv2 = new TV("tv2",9.5);
        usableDeviceRepository.create(tv1);
        usableDeviceRepository.create(tv2);

        Car c1 = new Car("c1", 100);
        SportInventory bike = new SportInventory("bike", 50);
        auxiliaryRepository.create(bike);
        auxiliaryRepository.create(c1);

        Location room1 = new Location("room1", LocationType.ROOM);
        Location room2 = new Location("room2", LocationType.ROOM);
        Location room3 = new Location("room3", LocationType.ROOM);
        Location garage = new Location("garage", LocationType.GARAGE);
        room1.addEntity(p1);
        room1.addEntity(p4);
        room1.addEntity(b1);
        room1.addEntity(b2);
        room1.addEntity(b3);
        room1.addEntity(b4);
        room1.addEntity(ds1);
        room1.addEntity(tv1);
        room2.addEntity(p2);
        room2.addEntity(bike);
        room2.addEntity(f1);
        room2.addEntity(tv2);
        room3.addEntity(p3);
        garage.addEntity(c1);
        locationRepository.create(room1);
        locationRepository.create(room2);
        locationRepository.create(room3);
        locationRepository.create(garage);
    }

}
