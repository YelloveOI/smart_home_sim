package cz.cvut.fel.smarthome.model.entities.basic;

import cz.cvut.fel.smarthome.model.ActivityType;
import cz.cvut.fel.smarthome.model.entities.basic.interfaces.IActive;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Active implements IActive {

    private final Map<ActivityType, Integer> timeSpent;

    private ActivityType currentActivity;
    private LocalDateTime clock;

    public Active() {
        this.timeSpent = new HashMap<>();
        this.currentActivity = ActivityType.A_FREE;
        this.clock = LocalDateTime.now();
    }

    @Override
    public ActivityType getCurrentActivity() {
        return currentActivity;
    }

    @Override
    public void startActivity(ActivityType activity) {
        stopActivity();
        currentActivity = activity;
    }

    @Override
    public void stopActivity() {
        Integer timeDifference = LocalDateTime.now().getSecond() - clock.getSecond();
        if(timeSpent.containsKey(currentActivity)) {
            timeSpent.replace(currentActivity, timeSpent.get(currentActivity) + timeDifference);
        } else {
            timeSpent.put(currentActivity, timeDifference);
        }

        clock = LocalDateTime.now();
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


        return sb.toString();
    }
}
