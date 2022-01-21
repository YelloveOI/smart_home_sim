package cz.cvut.fel.smarthome.model.event.event_context;

import cz.cvut.fel.smarthome.model.action.Action;
import cz.cvut.fel.smarthome.model.entities.person.Person;
import cz.cvut.fel.smarthome.model.entities.pet.Pet;
import cz.cvut.fel.smarthome.model.event.Event;
import cz.cvut.fel.smarthome.model.event.PlainEvent;

import java.time.LocalDateTime;

public class PetEventContext {

    public static Event act(Pet pet, Action action) {
        return new PlainEvent(
                Person.class, pet.getName(), LocalDateTime.now(), "acts " + action.getClass().getSimpleName(), 1
        );
    }

    public static Event tryAct(Pet pet, Action action) {
        return new PlainEvent(
                Person.class, pet.getName(), LocalDateTime.now(), "try acts " + action.getClass().getSimpleName(), 1
        );
    }

}
