package cz.cvut.fel.smarthome.model.event.event_context;

import cz.cvut.fel.smarthome.model.actor.action.Action;
import cz.cvut.fel.smarthome.model.actor.person.Person;
import cz.cvut.fel.smarthome.model.event.Event;
import cz.cvut.fel.smarthome.model.event.PlainEvent;
import cz.cvut.fel.smarthome.model.interfaces.IUseable;

import java.time.LocalDateTime;

public class PersonEventContext {

    public static Event goSport(Person person) {
        return new PlainEvent(
                Person.class, person.getName(), LocalDateTime.now(), "going sport", 1
        );
    }

    public static Event goWork(Person person) {
        return new PlainEvent(
                Person.class, person.getName(), LocalDateTime.now(), "going work", 1
        );
    }

    public static Event goProcrastinate(Person person) {
        return new PlainEvent(
                Person.class, person.getName(), LocalDateTime.now(), "going procrastinate", 1
        );
    }

    public static Event getFree(Person person) {
        return new PlainEvent(
                Person.class, person.getName(), LocalDateTime.now(), "is free now", 1
        );
    }

    public static Event cantUse(Person person, IUseable useable) {
        return new PlainEvent(
                Person.class, person.getName(), LocalDateTime.now(), "cant use " + useable, 1
        );
    }

    public static Event act(Person person, Action action) {
        return new PlainEvent(
                Person.class, person.getName(), LocalDateTime.now(), "acts " + action.getClass().getSimpleName(), 1
        );
    }

    public static Event imBusy(Person person) {
        return new PlainEvent(
                Person.class, person.getName(), LocalDateTime.now(), "is too busy to do smth", 1
        );
    }
}
