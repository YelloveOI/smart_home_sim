package cz.cvut.fel.smarthome.model.entities.basic;

import cz.cvut.fel.smarthome.model.entities.basic.interfaces.IActive;

import java.time.LocalDateTime;
import java.util.Objects;

public class Active implements IActive {

    private String currentActivity;
    private Integer activityTime;
    private LocalDateTime clock;

    public Active() {
        this.currentActivity = "FREE";
        this.activityTime = 0;
        this.clock = LocalDateTime.now();
    }

    @Override
    public String getCurrentActivity() {
        if(Objects.equals(currentActivity, "FREE")) return currentActivity;
        Integer timeDifference = LocalDateTime.now().getSecond() - clock.getSecond();
        if(timeDifference >= activityTime) {
            activityTime = 0;
            currentActivity = "FREE";
        }
        return currentActivity;
    }

    @Override
    public Boolean setActivity(String activity, Integer timeInSecond) {
        getCurrentActivity();
        if(!Objects.equals(currentActivity, "FREE")) return false;
        clock = LocalDateTime.now();
        activityTime = timeInSecond;

        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("Current activity:\t")
                .append(currentActivity);
        if(Objects.equals(currentActivity, "FREE")) return sb.toString();

        sb
                .append("\ttime left: ")
                .append(LocalDateTime.now().getSecond() - clock.getSecond());

        return sb.toString();
    }
}
