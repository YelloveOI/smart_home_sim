package cz.cvut.fel.smarthome.model.basic.interfaces;

import cz.cvut.fel.smarthome.model.basic.ActivityType;

public interface IActive {

    ActivityType getCurrentActivity();

    void startActivity(ActivityType activity);

    void stopActivity();

}
