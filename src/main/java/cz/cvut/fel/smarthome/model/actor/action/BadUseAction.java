package cz.cvut.fel.smarthome.model.actor.action;

import cz.cvut.fel.smarthome.model.actor.Person;
import cz.cvut.fel.smarthome.model.actor.Pet;
import cz.cvut.fel.smarthome.model.auxiliary.IUse;

public class BadUseAction extends Action<IUse> {

    public BadUseAction(IUse subject) {
        super(subject);
    }

    @Override
    public void visit(Person actor) {
        subject.badUse();
    }

    @Override
    public void visit(Pet actor) {
        subject.badUse();
        subject.badUse();
    }
}
