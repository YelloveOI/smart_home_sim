package cz.cvut.fel.smarthome.model.actor.pet;

import cz.cvut.fel.smarthome.model.actor.pet.state.FreePetState;
import cz.cvut.fel.smarthome.model.actor.pet.state.TiredPetState;
import cz.cvut.fel.smarthome.model.interfaces.IActor;
import cz.cvut.fel.smarthome.model.actor.action.Action;
import cz.cvut.fel.smarthome.model.actor.pet.state.PetState;

//TODO add state mechanics (hunger etc)
public class Pet implements IActor {

    private final String name;
    private PetState petState;
    private int tireMeter;

    public Pet(String name) {
        this.name = name;
        this.petState = new FreePetState(this);
        this.tireMeter = 5;
    }

    public void setPetState(PetState petState) {
        this.petState = petState;
    }

    public String getName() {
        return name;
    }

    @Override
    public void act(Action action) {
        petState.act(action);
    }

    public void sleep(){
        petState.sleep();
    }

    public void setTireMeter(int tireMeter) {
        this.tireMeter = tireMeter;
    }

    public void getMoreTired(){
        tireMeter--;
        if(tireMeter<=0){
            this.setPetState(new TiredPetState(this));
        }
    }
}
