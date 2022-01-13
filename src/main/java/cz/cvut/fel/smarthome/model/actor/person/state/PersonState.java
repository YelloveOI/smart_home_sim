package cz.cvut.fel.smarthome.model.actor.person.state;

import cz.cvut.fel.smarthome.model.actor.person.Person;
import cz.cvut.fel.smarthome.model.actor.action.Action;
import cz.cvut.fel.smarthome.model.auxiliary.Auxiliary;
import cz.cvut.fel.smarthome.model.device.Device;

public abstract class PersonState {

    protected final Person person;

    public PersonState(Person person) {
        this.person = person;
    }


    public abstract void act(Action action);

    public abstract void goSport(Auxiliary sportAux);
    public abstract void goWork(Auxiliary workAux);
    public abstract void goProcrastinate(Device procrastinator);
    public abstract void getFreeFromActivity();

}
