package cz.cvut.fel.smarthome.model;

public class AbstractEntity {

    protected final String name;

    public AbstractEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
