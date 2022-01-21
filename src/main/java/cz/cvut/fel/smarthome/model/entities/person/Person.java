package cz.cvut.fel.smarthome.model.entities.person;

import cz.cvut.fel.smarthome.model.entities.AbstractEntity;
import cz.cvut.fel.smarthome.model.action.Action;
import cz.cvut.fel.smarthome.model.interfaces.IActive;
import cz.cvut.fel.smarthome.model.interfaces.IActor;
import cz.cvut.fel.smarthome.model.entities.person.state.FreePersonState;
import cz.cvut.fel.smarthome.model.entities.person.state.PersonState;

public class Person extends AbstractEntity<String> implements IActor, IActive {

    private final PersonRoleType role;
    private String location;
    transient private PersonState personState;

    public Person(String name, PersonRoleType role, String location) {
        super(name);
        this.role = role;
        this.location = location;
        this.personState = new FreePersonState(this);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPersonState(PersonState personState) {
        this.personState = personState;
    }

    public PersonRoleType getRole() {
        return role;
    }

    @Override
    public void act(Action action) {
        personState.act(action);
    }

    @Override
    public void becomeBusy() {
        personState.becomeBusy();
    }

    @Override
    public void getFree() {
        personState.getFree();
    }

    @Override
    public Boolean isFree() {
        return personState.isFree();
    }
}
