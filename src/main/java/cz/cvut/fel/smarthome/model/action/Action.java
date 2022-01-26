package cz.cvut.fel.smarthome.model.action;


import cz.cvut.fel.smarthome.model.entities.movable.AbstractAlive;

public abstract class Action<T> {

    protected final T subject;

    public Action(T subject) {
        this.subject = subject;
    }

    abstract public void visit(AbstractAlive actor);

//    abstract public void visit(Pet actor);

}
