package cz.cvut.fel.smarthome.model.consumers;

import cz.cvut.fel.smarthome.model.enums.State;

import java.util.Map;

public class Consumer {

    private String content;
    private String consumptionType;
    private State currentState;
    private Map<State, Double> consumptionMap;
    private Double durability;
    private String manual;

}
