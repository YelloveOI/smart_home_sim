package cz.cvut.fel.smarthome.model.action;

import cz.cvut.fel.smarthome.model.entities.alive.AbstractAlive;
import cz.cvut.fel.smarthome.model.entities.basic.interfaces.IUsable;

public class MisuseAction extends Action<IUsable> {

    public MisuseAction(IUsable subject) {
        super(subject);
    }

    @Override
    public void visit(AbstractAlive actor) {
        subject.use();
    }

//    @Override
//    public void visit(Pet actor) {
//        subject.use();
//        subject.use();
//    }
}
