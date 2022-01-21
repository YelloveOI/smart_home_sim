package cz.cvut.fel.smarthome.model.action;

import cz.cvut.fel.smarthome.model.entities.person.Person;
import cz.cvut.fel.smarthome.model.entities.pet.Pet;
import cz.cvut.fel.smarthome.model.interfaces.IUseable;

public class BadUseAction extends Action<IUseable> {

    public BadUseAction(IUseable subject) {
        super(subject);
    }

    @Override
    public void visit(Person actor) {
        subject.misuse();
    }

    @Override
    public void visit(Pet actor) {
        subject.misuse();
        subject.misuse();
    }
}
