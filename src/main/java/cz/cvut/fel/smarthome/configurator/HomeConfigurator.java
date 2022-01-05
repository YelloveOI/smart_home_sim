package cz.cvut.fel.smarthome.configurator;

import cz.cvut.fel.smarthome.model.Floor;
import cz.cvut.fel.smarthome.model.Home;
import cz.cvut.fel.smarthome.model.Place;
import cz.cvut.fel.smarthome.model.moveables.Person;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;
import cz.cvut.fel.smarthome.simpleDI.context.ApplicationContext;

public class HomeConfigurator {

    @Inject
    private Home subject;

    @Inject
    private ApplicationContext context;

    public HomeConfigurator() {
    }

    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    public Home getSubject() {
        return subject;
    }

    public void setSubject(Home subject) {
        this.subject = subject;
    }

    public ApplicationContext getContext() {
        return context;
    }

    public Home build() {
        //TODO добавить "проверку на реальность"
        return subject;
    }

    public HomeConfigurator setFloorsQuantity(Integer quantity) {
        for(int i = 0; i < quantity; i++) {
            subject.addFloor(context.getNewBean(Floor.class).setNumber(i));
        }
        return this;
    }

    public HomeConfigurator setOwnersQuantity(Integer quantity) {
        for(int i = 0; i < quantity; ++i) {
            subject.addOwner(context.getNewBean(Person.class));
        }
        return this;
    }

    public HomeConfigurator setPlace(Integer floorNumber, String placeName) {
        subject.getFloors().get(floorNumber).addPlace(context.getNewBean(Place.class).setName(placeName));
        return this;
    }

}
