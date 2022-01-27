package cz.cvut.fel.smarthome.model.entities.alive;

import cz.cvut.fel.smarthome.model.entities.Order;
import cz.cvut.fel.smarthome.model.entities.basic.AbstractEntity;
import cz.cvut.fel.smarthome.model.entities.basic.Active;

public abstract class AbstractAlive extends AbstractEntity<String> {

    protected final Active active;

    public AbstractAlive(String name) {
        super(name);
        this.active = new Active();
    }

    //true = alive doing requested order, false = nothing changed (it's busy)
    abstract public Boolean order(Order order);

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("> Alive: ")
                .append(getId())
                .append(active)
                .append("\n--------------------------------");

        return sb.toString();
    }
}
