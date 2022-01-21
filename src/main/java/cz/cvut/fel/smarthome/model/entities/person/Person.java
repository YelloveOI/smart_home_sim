package cz.cvut.fel.smarthome.model.entities.person;

import cz.cvut.fel.smarthome.model.entities.AbstractEntity;
import cz.cvut.fel.smarthome.model.action.Action;
import cz.cvut.fel.smarthome.model.interfaces.IActive;
import cz.cvut.fel.smarthome.model.interfaces.IActor;
import cz.cvut.fel.smarthome.model.entities.person.state.FreePersonState;
import cz.cvut.fel.smarthome.model.entities.person.state.PersonState;
import cz.cvut.fel.smarthome.model.interfaces.ILocateable;
import cz.cvut.fel.smarthome.model.interfaces.IUseable;

public class Person extends AbstractEntity<String> implements IActor, IActive, ILocateable {

    private final PersonRoleType role;
    private String location;
    private IUseable inUse;
    transient private PersonState personState;

    public Person(String name, PersonRoleType role, String location) {
        super(name);
        this.role = role;
        this.location = location;
        this.personState = new FreePersonState(this);
        this.inUse = null;
    }


    public void setPersonState(PersonState personState) {
        this.personState = personState;
    }

    public PersonRoleType getRole() {
        return role;
    }

    public IUseable getInUse() {
        return inUse;
    }

    public void setInUse(IUseable inUse) {
        this.inUse = inUse;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void act(Action action) {
        personState.act(action);
    }

    @Override
    public void becomeBusy(IUseable useable) {
        personState.becomeBusy(useable);
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
