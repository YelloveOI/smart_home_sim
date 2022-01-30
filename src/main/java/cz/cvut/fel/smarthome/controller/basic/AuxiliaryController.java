package cz.cvut.fel.smarthome.controller.basic;

import cz.cvut.fel.smarthome.controller.EventController;
import cz.cvut.fel.smarthome.controller.ReportController;
import cz.cvut.fel.smarthome.model.entities.alive.AbstractAlive;
import cz.cvut.fel.smarthome.model.entities.auxiliary.AbstractAuxiliary;
import cz.cvut.fel.smarthome.model.event.Event;
import cz.cvut.fel.smarthome.model.event.EventType;
import cz.cvut.fel.smarthome.model.exception.IllegalUseException;
import cz.cvut.fel.smarthome.model.service.AuxiliaryService;
import cz.cvut.fel.smarthome.model.service.LocationService;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;
import javassist.NotFoundException;

import java.util.Arrays;

public class AuxiliaryController {

    @Inject
    private AuxiliaryService auxiliaryService;
    @Inject
    private LocationService locationService;
    @Inject
    private ReportController reportController;

    public void use(String houseID, String auxiliaryID) {
        try {
            auxiliaryService.use(auxiliaryID);
            locationService.deallocate(houseID, auxiliaryService.getAuxiliary(auxiliaryID));

            reportController.report("Auxiliary " + auxiliaryID + " now in use");
        } catch (NotFoundException e1) {
            System.out.println(e1);
        } catch (IllegalUseException e2) {
            System.out.println(e2);
            e2.printStackTrace();
        }
    }

    public void stopUse(String houseID, String auxiliaryID) {
        try {
            auxiliaryService.stopUse(auxiliaryID);
            locationService.locateBack(houseID, auxiliaryService.getAuxiliary(auxiliaryID));

            reportController.report("Auxiliary " + auxiliaryID + " now is free");
        } catch (NotFoundException e1) {
            System.out.println(e1);
        } catch (IllegalUseException e2) {
            System.out.println(e2);
            e2.printStackTrace();
        }
    }

    public void repair(String auxiliaryID) {
        try {
            auxiliaryService.repair(auxiliaryID);
            reportController.report("Auxiliary " + auxiliaryID + " repaired");
        } catch (NotFoundException e1) {
            System.out.println(e1);
        }
    }

}
