package cz.cvut.fel.smarthome.model.entities.pet;

import cz.cvut.fel.smarthome.model.entities.AbstractEntity;
import cz.cvut.fel.smarthome.model.entities.pet.state.FedPetState;
import cz.cvut.fel.smarthome.model.entities.pet.state.HungryPetState;
import cz.cvut.fel.smarthome.model.interfaces.IActor;
import cz.cvut.fel.smarthome.model.action.Action;
import cz.cvut.fel.smarthome.model.entities.pet.state.PetState;
import cz.cvut.fel.smarthome.model.interfaces.ILocateable;

public class Pet extends AbstractEntity<String> implements IActor, ILocateable {

    private PetState state;
    private String location;
    private Integer hungerLevel;

    public Pet(String name, String location) {
        super(name);
        this.hungerLevel = 0;
        this.location = location;
    }

    public void setState(PetState state) {
        this.state = state;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void act(Action action) {
        action.visit(this);
    }

    public void getHungry() {
        hungerLevel++;
        if(hungerLevel > 5) {
            setState(new HungryPetState(this));
        }
    }

    public void feed() {
        hungerLevel -= 5;
        if(hungerLevel <= 5) {
            setState(new FedPetState(this));
        }
    }
}
