package cz.cvut.fel.smarthome.locator;

import cz.cvut.fel.smarthome.model.AbstractEntity;
import cz.cvut.fel.smarthome.model.location.Location;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


//TODO
public class Locator {

    private final Map<AbstractEntity, Location> entityMap;
    private final String houseName;

    public Locator(String houseName) {
        this.houseName = houseName;
        this.entityMap = new ConcurrentHashMap<>();
    }

}
