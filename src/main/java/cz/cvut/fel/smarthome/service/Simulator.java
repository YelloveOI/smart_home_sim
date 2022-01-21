package cz.cvut.fel.smarthome.service;

import cz.cvut.fel.smarthome.repository.interfaces.PersonRepository;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

public class Simulator {

    @Inject
    private PersonService personService;
    @Inject
    private Locator locator;


//    public void doSmth1() {
//
//        personService.goWork("HOUSE1", "Wasua");
//        personService.goSport("HOUSE1", "Manya");
//        personService.goProcrastinate("Tolik");
//        personService.goProcrastinate("Bolik");
//        personService.goProcrastinate("Trolik");
//        personService.getFreeFromActivity("HOUSE1", "Wasua");
//        personService.getFreeFromActivity("HOUSE1", "Tolik");
//        personService.goSport("HOUSE1", "Tolik");
//        personService.getFreeFromActivity("HOUSE1", "Bolik");
//        personService.getFreeFromActivity("HOUSE1", "Manya");
//        personService.goProcrastinate("Manya");
//        personService.goSport("HOUSE1", "Bolik");
//        personService.goProcrastinate("Zhmyshenko Valerij Albertovich");
//
//   }
//
//   public void doSmth2() {
//
//       personService.goSport("HOUSE2", "Wasua");
//       personService.goProcrastinate("Zhmyshenko Valerij Albertovich");
//       personService.goWork("HOUSE2", "Tolik");
//       personService.goSport("HOUSE2", "Bolik");
//       personService.goProcrastinate("Trolik");
//       personService.getFreeFromActivity("HOUSE1", "Wasua");
//       personService.getFreeFromActivity("HOUSE1", "Tolik");
//       personService.goSport("HOUSE1", "Tolik");
//       personService.getFreeFromActivity("HOUSE1", "Bolik");
//       personService.getFreeFromActivity("HOUSE1", "Manya");
//       personService.goProcrastinate("Manya");
//       personService.goSport("HOUSE1", "Bolik");
//       personService.goProcrastinate("Zhmyshenko Valerij Albertovich");
//
//   }

}
