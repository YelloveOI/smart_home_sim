package cz.cvut.fel.smarthome.model.basic;

import cz.cvut.fel.smarthome.model.basic.interfaces.IActive;

import java.util.HashMap;
import java.util.Map;

/**
 * A primitive class for active entities
 * Processes incoming activities and keeps records
 */
public class Active implements IActive {

    private final Map<ActivityType, Long> timeSpent;

    private ActivityType currentActivity;

    public Active() {
        this.timeSpent = new HashMap<>();
        this.currentActivity = ActivityType.A_FREE;
    }

    @Override
    public ActivityType getCurrentActivity() {
        return currentActivity;
    }

    @Override
    public void startActivity(ActivityType activity) {
        stopActivity();

        if(timeSpent.containsKey(activity)) {
            timeSpent.replace(activity, timeSpent.get(activity) + 1);
        } else {
            timeSpent.put(activity, 1L);
        }

        currentActivity = activity;
    }

    @Override
    public void stopActivity() {
        currentActivity = ActivityType.A_FREE;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("Current activity:\t")
                .append(currentActivity)
                .append("\n\t Time spending: ");

        for(ActivityType at : timeSpent.keySet()) {
            sb
                    .append("\t")
                    .append(at)
                    .append(":")
                    .append(timeSpent.get(at));
        }

        sb.append("\n");

        return sb.toString();
    }
}
