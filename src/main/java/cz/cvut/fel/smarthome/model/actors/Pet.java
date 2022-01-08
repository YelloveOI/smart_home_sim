package cz.cvut.fel.smarthome.model.actors;

public class Pet {

    private final String name;
    private final Person owner;

    public Pet(String name, Person owner) {
        this.name = name;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public Person getOwner() {
        return owner;
    }
}
