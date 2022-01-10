package cz.cvut.fel.smarthome.model.interfaces;

import cz.cvut.fel.smarthome.model.actor.action.Action;

public interface IActor extends INamed {

    void act(Action action);

}
