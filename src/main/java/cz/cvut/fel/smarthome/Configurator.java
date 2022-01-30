package cz.cvut.fel.smarthome;

import cz.cvut.fel.smarthome.controller.BusynessController;
import cz.cvut.fel.smarthome.controller.EventController;
import cz.cvut.fel.smarthome.model.entities.auxiliary.Car;
import cz.cvut.fel.smarthome.model.entities.auxiliary.SportInventory;
import cz.cvut.fel.smarthome.model.entities.device.*;
import cz.cvut.fel.smarthome.model.entities.location.House;
import cz.cvut.fel.smarthome.model.entities.location.HouseBuilder;
import cz.cvut.fel.smarthome.model.entities.alive.Person;
import cz.cvut.fel.smarthome.model.event.Event;
import cz.cvut.fel.smarthome.model.repository.interfaces.*;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

/**
 * Configures all smart home system
 */
public class Configurator {

    @Inject
    private AliveRepository aliveRepository;
    @Inject
    private HouseRepository houseRepository;
    @Inject
    private SimpleDeviceRepository simpleDeviceRepository;
    @Inject
    private StorageDeviceRepository storageDeviceRepository;
    @Inject
    private UsableDeviceRepository usableDeviceRepository;
    @Inject
    private AuxiliaryRepository auxiliaryRepository;
    @Inject
    private BusynessController busynessController;
    @Inject
    private EventController eventController;

    private String houseName;

    public void config1(String houseName) {
        this.houseName = houseName;

        Person p1 = new Person("Ivan");
        Person p2 = new Person("Robert");
        Person p3 = new Person("Kate");
        Person p4 = new Person("Strasidlo");
        aliveRepository.create(p1);
        aliveRepository.create(p2);
        aliveRepository.create(p3);
        aliveRepository.create(p4);

        Blind b1 = new Blind("b1",  5.2);
        Blind b2 = new Blind("b2",  5.2);
        Blind b3 = new Blind("b3",  5.2);
        Blind b4 = new Blind("b4",  5.2);
        DaylightSensor ds1 = new DaylightSensor("ds1",1.2);
        Fuse fs1 = new Fuse("fs1", 1.9);
        simpleDeviceRepository.create(b1);
        simpleDeviceRepository.create(b2);
        simpleDeviceRepository.create(b3);
        simpleDeviceRepository.create(b4);
        simpleDeviceRepository.create(fs1);
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

        HouseBuilder hb = new HouseBuilder();
        House house = hb
                .addRoom("room1")
                .addRoom("room2")
                .addRoom("room3")
                .addGarage("garage1")
                .addEmbedded("window1", "room1")
                .addEmbedded("window2", "room1")
                .addEmbedded("window3", "room2")
                .addEmbedded("window4", "room2")
                .setHouseName(houseName)
                .addPreferredLocation(p1, "room1")
                .addPreferredLocation(p2, "room2")
                .addPreferredLocation(p3, "room3")
                .addPreferredLocation(p4, "room1")
                .addPreferredLocation(c1, "garage1")
                .addPreferredLocation(bike, "room1")
                .build();

        house.allocateEntity(p1, "room1");
        house.allocateEntity(p2, "room2");
        house.allocateEntity(p3, "room3");
        house.allocateEntity(p4, "room4");
        house.allocateEntity(b1, "window1");
        house.allocateEntity(b2, "window2");
        house.allocateEntity(b3, "window3");
        house.allocateEntity(b4, "window4");
        house.allocateEntity(f1, "room2");
        house.allocateEntity(tv1, "room1");
        house.allocateEntity(tv2, "room2");
        house.allocateEntity(c1, "garage1");
        houseRepository.create(house);

        busynessController.init();
        eventController.init();
    }

    public void config2(String houseName) {
        this.houseName = houseName;

        Person p1 = new Person("Ivan");
        Person p2 = new Person("Robert");
        Person p3 = new Person("Kate");
        Person p4 = new Person("Strasidlo");
        Person p5 = new Person("David");
        Person p6 = new Person("Martin");
        aliveRepository.create(p1);
        aliveRepository.create(p2);
        aliveRepository.create(p3);
        aliveRepository.create(p4);
        aliveRepository.create(p5);
        aliveRepository.create(p6);

        Blind b1 = new Blind("b1",  5.2);
        Blind b2 = new Blind("b2",  5.2);
        DaylightSensor ds1 = new DaylightSensor("ds1",1.2);
        Fuse fs1 = new Fuse("fs1", 1.9);
        simpleDeviceRepository.create(b1);
        simpleDeviceRepository.create(b2);
        simpleDeviceRepository.create(fs1);
        simpleDeviceRepository.create(ds1);

        Fridge f1 = new Fridge("f1", "room2", 20.1);
        storageDeviceRepository.create(f1);

        TV tv1 = new TV("tv1", 12.4);
        TV tv2 = new TV("tv2",9.5);
        usableDeviceRepository.create(tv1);
        usableDeviceRepository.create(tv2);

        Car c1 = new Car("c1", 100);
        Car c2 = new Car("c2", 60);
        SportInventory bike = new SportInventory("bike", 50);
        SportInventory ski = new SportInventory("ski", 20);
        auxiliaryRepository.create(bike);
        auxiliaryRepository.create(ski);
        auxiliaryRepository.create(c1);
        auxiliaryRepository.create(c2);

        HouseBuilder hb = new HouseBuilder();
        House house = hb
                .addRoom("room1")
                .addRoom("room2")
                .addRoom("room3")
                .addRoom("room4")
                .addRoom("room5")
                .addGarage("garage1")
                .addRoom("garage2")
                .addEmbedded("window1", "room1")
                .addEmbedded("window2", "room1")
                .addEmbedded("window3", "room2")
                .addEmbedded("window4", "room2")
                .setHouseName(houseName)
                .addPreferredLocation(p1, "room1")
                .addPreferredLocation(p2, "room2")
                .addPreferredLocation(p3, "room3")
                .addPreferredLocation(p4, "room1")
                .addPreferredLocation(p5, "room4")
                .addPreferredLocation(p6, "room5")
                .addPreferredLocation(c1, "garage1")
                .addPreferredLocation(c2, "garage2")
                .addPreferredLocation(bike, "room1")
                .addPreferredLocation(ski, "garage1")
                .build();

        house.allocateEntity(p1, "room1");
        house.allocateEntity(p2, "room2");
        house.allocateEntity(p3, "room3");
        house.allocateEntity(p4, "room4");
        house.allocateEntity(p5, "room5");
        house.allocateEntity(p6, "room3");
        house.allocateEntity(b1, "window1");
        house.allocateEntity(b2, "window2");
        house.allocateEntity(f1, "room2");
        house.allocateEntity(tv1, "room1");
        house.allocateEntity(tv2, "room2");
        house.allocateEntity(c1, "garage1");
        house.allocateEntity(c2, "garage2");
        house.allocateEntity(bike, "garage1");
        house.allocateEntity(ski, "garage2");
        houseRepository.create(house);

        busynessController.init();
        eventController.init();
    }

    public String getHouseName() {
        return houseName;
    }

}
