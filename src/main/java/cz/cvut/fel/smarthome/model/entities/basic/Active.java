package cz.cvut.fel.smarthome.model.entities.basic;

import cz.cvut.fel.smarthome.model.entities.basic.interfaces.IActive;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Active implements IActive {

    private final Map<String, Integer> timeSpent;

    private String currentActivity;
    private LocalDateTime clock;

    public Active() {
        this.timeSpent = new HashMap<>();
        this.currentActivity = "FREE";
        this.clock = LocalDateTime.now();
    }

    @Override
    public String getCurrentActivity() {
        return currentActivity;
    }

    @Override
    public void startActivity(String activity) {
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
        currentActivity = "FREE";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("Current activity:\t")
                .append(currentActivity)
                .append("\n\t Time spending: ");

        for(String s : timeSpent.keySet()) {
            sb
                    .append("\t")
                    .append(s)
                    .append(":")
                    .append(timeSpent.get(s));
        }


        return sb.toString();
    }
}
