package cz.cvut.fel.smarthome.model.actor.person.state;

import cz.cvut.fel.smarthome.model.actor.person.Person;
import cz.cvut.fel.smarthome.model.actor.action.Action;
import cz.cvut.fel.smarthome.model.event.ReportContext;

public class BusyPersonState extends PersonState {

    public BusyPersonState(Person person) {
        super(person);
    }

    @Override
    public void act(Action action) {
        ReportContext
                .createReportEvent(this.getClass(), person.getName(),"cannot tear himself away from the previous case")
                .execute();
    }
}
