package cz.cvut.fel.smarthome.model.entities.basic.interfaces;

import cz.cvut.fel.smarthome.model.activity.ActivityType;

public interface IActive {

    ActivityType getCurrentActivity();

    void startActivity(ActivityType activity);

    void stopActivity();

}
