package cz.cvut.fel.smarthome.model.actor.person.state;

import cz.cvut.fel.smarthome.model.actor.person.Person;
import cz.cvut.fel.smarthome.model.actor.action.Action;
import cz.cvut.fel.smarthome.model.event.ReportContext;

public class FreePersonState extends PersonState {

    public FreePersonState(Person person) {
        super(person);
    }

    @Override
    public void act(Action action) {
        action.visit(person);
        ReportContext
                .createReportEvent(this.getClass(), person.getName(),"takes on a new business")
                .execute();
    }

    @Override
    public void goSport() {

    }

    @Override
    public void goWork() {

    }
}
