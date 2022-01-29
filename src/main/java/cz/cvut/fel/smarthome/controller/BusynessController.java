package cz.cvut.fel.smarthome.controller;

import cz.cvut.fel.smarthome.model.entities.auxiliary.AbstractAuxiliary;
import cz.cvut.fel.smarthome.model.entities.basic.AbstractEntity;
import cz.cvut.fel.smarthome.model.entities.device.AbstractUsableDevice;
import cz.cvut.fel.smarthome.model.repository.interfaces.AliveRepository;
import cz.cvut.fel.smarthome.model.repository.interfaces.AuxiliaryRepository;
import cz.cvut.fel.smarthome.model.repository.interfaces.UsableDeviceRepository;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BusynessController {

    @Inject
    private AliveRepository aliveRepository;
    @Inject
    private UsableDeviceRepository usableDeviceRepository;
    @Inject
    private AuxiliaryRepository auxiliaryRepository;


    //true = busy, false = free
    private final Map<String, Boolean> busynessMap;

    public BusynessController() {
        this.busynessMap = new HashMap<>();
    }

    public void takeData() {
        for(
                String s : aliveRepository.findAll().stream()
                .map(AbstractEntity::getId)
                .collect(Collectors.toSet())
        ) {
            busynessMap.put(s, false);
        }

        for(
                String s : usableDeviceRepository.findAll().stream()
                .map(AbstractUsableDevice::getId)
                .collect(Collectors.toSet())
        ) {
            busynessMap.put(s, false);
        }

        for(
                String s : auxiliaryRepository.findAll().stream()
                .map(AbstractAuxiliary::getId)
                .collect(Collectors.toSet())
        ) {
            busynessMap.put(s, false);
        }
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
