package cz.cvut.fel.smarthome.controller.basic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BusynessController {

    //true = busy, false = free
    private final Map<String, Boolean> busynessMap;

    public BusynessController() {
        this.busynessMap = new HashMap<>();
    }
    
    public void releaseFromActivity(String activeEntityID) {
        if(busynessMap.containsKey(activeEntityID)) {
            busynessMap.replace(activeEntityID, false);
        } else {
            busynessMap.put(activeEntityID, false);
        }
    }

    public void getActivity(String activeEntityID) {
        if (busynessMap.containsKey(activeEntityID)) {
            busynessMap.replace(activeEntityID, true);
        } else {
            busynessMap.put(activeEntityID, true);
        }
    }

    public Set<String> getFreePersonsID() {
        Set<String> result = new HashSet<>();

        for(String s : busynessMap.keySet()) {
            if(s.contains("PERSON_") && !busynessMap.get(s)) {
                result.add(s);
            }
        }

        return result;
    }

    public Set<String> getFreePetsID() {
        Set<String> result = new HashSet<>();

        for(String s : busynessMap.keySet()) {
            if(s.contains("PET_") && !busynessMap.get(s)) {
                result.add(s);
            }
        }

        return result;
    }

    public Set<String> getFreeDevicesID() {
        Set<String> result = new HashSet<>();

        for(String s : busynessMap.keySet()) {
            if(s.contains("USABLE_") && !busynessMap.get(s)) {
                result.add(s);
            }
        }

        return result;
    }

    public Set<String> getFreeCarsID() {
        Set<String> result = new HashSet<>();

        for(String s : busynessMap.keySet()) {
            if(s.contains("CAR_") && !busynessMap.get(s)) {
                result.add(s);
            }
        }

        return result;
    }

    public Set<String> getFreeSportInventoriesID() {
        Set<String> result = new HashSet<>();

        for(String s : busynessMap.keySet()) {
            if(s.contains("SPORT_") && busynessMap.get(s)) {
                result.add(s);
            }
        }

        return result;
    }

}
