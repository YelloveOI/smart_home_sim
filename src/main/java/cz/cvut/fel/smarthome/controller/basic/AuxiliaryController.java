package cz.cvut.fel.smarthome.controller.basic;

import cz.cvut.fel.smarthome.Reporter;
import cz.cvut.fel.smarthome.model.exception.IllegalUseException;
import cz.cvut.fel.smarthome.model.service.AuxiliaryService;
import cz.cvut.fel.smarthome.model.service.LocationService;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;
import javassist.NotFoundException;

/**
 * Implements simple auxiliary's use-cases
 * Process exceptions to services
 * Throw messages to reporter
 */
public class AuxiliaryController {

    @Inject
    private AuxiliaryService auxiliaryService;
    @Inject
    private LocationService locationService;
    @Inject
    private Reporter reporter;

    public void use(String houseID, String auxiliaryID) {
        try {
            auxiliaryService.use(auxiliaryID);
            locationService.deallocate(houseID, auxiliaryService.getAuxiliary(auxiliaryID));

            reporter.report("Auxiliary " + auxiliaryID + " now in use");
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

            reporter.report("Auxiliary " + auxiliaryID + " now is free");
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
            reporter.report("Auxiliary " + auxiliaryID + " repaired");
        } catch (NotFoundException e1) {
            System.out.println(e1);
        }
    }

}
