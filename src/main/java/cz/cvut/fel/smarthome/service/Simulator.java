package cz.cvut.fel.smarthome.service;

import cz.cvut.fel.smarthome.repository.interfaces.PersonRepository;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

public class Simulator {

    @Inject
    private PersonService personService;
    @Inject
    private Locator locator;



}
