package cz.cvut.fel.smarthome.model.action;

import cz.cvut.fel.smarthome.model.entities.person.Person;
import cz.cvut.fel.smarthome.model.entities.pet.Pet;
import cz.cvut.fel.smarthome.model.entities.basic.interfaces.IUsable;

public class MisuseAction extends Action<IUsable> {

    public MisuseAction(IUsable subject) {
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
