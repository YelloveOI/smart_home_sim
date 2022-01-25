package cz.cvut.fel.smarthome.model.entities.person;

import cz.cvut.fel.smarthome.model.entities.AbstractEntity;
import cz.cvut.fel.smarthome.model.action.Action;
import cz.cvut.fel.smarthome.model.entities.basic.Locatable;
import cz.cvut.fel.smarthome.model.entities.device.UsableDevice;
import cz.cvut.fel.smarthome.model.IActor;
import cz.cvut.fel.smarthome.model.entities.person.state.FreePersonState;
import cz.cvut.fel.smarthome.model.entities.person.state.PersonState;
import cz.cvut.fel.smarthome.model.entities.basic.interfaces.ILocateable;

public class Person extends AbstractEntity<String> implements IActor, IActive, ILocateable {

    private final Active active;
    private final Locatable locatable;
    private final PersonRoleType role;
    transient private PersonState personState;

    public Person(String name, PersonRoleType role, String preferredLocation) {
        super(name);
        this.role = role;
        this.personState = new FreePersonState(this);
        this.active = new Active();
        this.locatable = new Locatable(preferredLocation);
    }


    public void setPersonState(PersonState personState) {
        this.personState = personState;
    }

    public PersonRoleType getRole() {
        return role;
    }

    @Override
    public void act(Action action) {
        //TODO
    }

    @Override
    public void goWork(Car car) {
        active.goWork(car);
    }

    @Override
    public void goSport(SportInventory sportInventory) {
        active.goSport(sportInventory);
    }

    @Override
    public void useDevice(UsableDevice usableDevice) {
        active.useDevice(usableDevice);
    }

    @Override
    public void goShop(Car car) {
        active.goShop(car);
    }

    @Override
    public void getFree() {
        active.getFree();
    }

    @Override
    public Boolean isFree() {
        return active.isFree();
    }

    @Override
    public String getLocation() {
        return locatable.getLocation();
    }

    @Override
    public void setLocation(String location) {
        locatable.setLocation(location);
    }

    @Override
    public void locateBack() {
        locatable.locateBack();
    }
}
