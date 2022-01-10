package cz.cvut.fel.smarthome.model.actor.person;

import cz.cvut.fel.smarthome.model.interfaces.IActor;
import cz.cvut.fel.smarthome.model.actor.action.Action;
import cz.cvut.fel.smarthome.model.actor.person.state.FreePersonState;
import cz.cvut.fel.smarthome.model.actor.person.state.PersonState;

public class Person implements IActor {

    private final String name;
    private PersonRoleType role;
    private PersonState personState;

    public Person(String name, PersonRoleType role) {
        this.name = name;
        this.role = role;
        this.personState = new FreePersonState(this);
    }

    public void setPersonState(PersonState personState) {
        this.personState = personState;
    }

    public String getName() {
        return name;
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
}
