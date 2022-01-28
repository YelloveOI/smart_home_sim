package cz.cvut.fel.smarthome.model.activity;

public record Activity(String activeObject, String activitySubject, ActivityType activityType, Integer endTime) {
}
