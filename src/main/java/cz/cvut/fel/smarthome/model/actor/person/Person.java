package cz.cvut.fel.smarthome.model.actor.person;

import cz.cvut.fel.smarthome.model.AbstractEntity;
import cz.cvut.fel.smarthome.model.actor.action.Action;
import cz.cvut.fel.smarthome.model.actor.person.state.FreePersonState;
import cz.cvut.fel.smarthome.model.actor.person.state.PersonState;
import cz.cvut.fel.smarthome.model.auxiliary.Auxiliary;
import cz.cvut.fel.smarthome.model.device.Device;
import cz.cvut.fel.smarthome.model.interfaces.IActive;
import cz.cvut.fel.smarthome.model.interfaces.IActor;
import cz.cvut.fel.smarthome.model.location.Location;
import cz.cvut.fel.smarthome.model.location.Outside;

import java.util.Objects;

public class Person extends AbstractEntity implements IActor, IActive {

    private PersonRoleType role;
    transient private PersonState personState;

    public Person(String name, PersonRoleType role) {
        super(name);
        this.role = role;
        this.personState = new FreePersonState(this);
    }

    public void setPersonState(PersonState personState) {
        this.personState = personState;
    }

    public PersonRoleType getRole() {
        return role;
    }

    public void setRole(PersonRoleType role) {
        this.role = role;
    }

    @Override
    public void act(Action action) {
        personState.act(action);
    }

    @Override
    public void goSport(Auxiliary sportAux) {
        personState.goSport(sportAux);
    }

    @Override
    public void goWork(Auxiliary workAux) {
        personState.goWork(workAux);
    }

    @Override
    public void goProcrastinate(Device procrastinator) {
        personState.goProcrastinate(procrastinator);
    }

    @Override
    public void getFreeFromActivity() {
        personState.getFreeFromActivity();
    }

}
