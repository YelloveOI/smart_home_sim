package cz.cvut.fel.smarthome.model.actor;

import cz.cvut.fel.smarthome.model.actor.action.Action;

public class Pet implements Actor {

    private final String name;

    public Pet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void act(Action action) {
        action.visit(this);
    }
}
