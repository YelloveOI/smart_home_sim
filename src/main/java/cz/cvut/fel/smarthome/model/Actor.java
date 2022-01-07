package cz.cvut.fel.smarthome.model;

import cz.cvut.fel.smarthome.model.consumers.Consumer;

public abstract class Actor {

    private String name;


    public abstract void act(Actor target);

    public abstract void act(Consumer target);

}
