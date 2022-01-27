package cz.cvut.fel.smarthome.controller.basic;

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

    public void use(String houseID, String auxiliaryID) {
        try {
            auxiliaryService.use(auxiliaryID);
            locationService.deallocate(houseID, auxiliaryService.getAuxiliary(auxiliaryID));
        } catch (NotFoundException e1) {
            System.out.println(e1);
        } catch (IllegalUseException e2) {
            System.out.println(e2);
            e2.printStackTrace();
        }
    }

    public void stopUse(String houseID, String auxiliaryID) {
        try {
            auxiliaryService.use(auxiliaryID);
            locationService.locateBack(houseID, auxiliaryService.getAuxiliary(auxiliaryID));
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
        } catch (NotFoundException e1) {
            System.out.println(e1);
        }
    }

}
