package cz.cvut.fel.smarthome.controller;

import cz.cvut.fel.smarthome.model.service.AuxiliaryService;
import cz.cvut.fel.smarthome.model.service.LocationService;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;
import javassist.NotFoundException;

public class AuxiliaryController {

    @Inject
    private AuxiliaryService auxiliaryService;
    @Inject
    private LocationService locationService;

    public void use(String houseID, String auxiliaryID) {
        try {
            auxiliaryService.use(auxiliaryID);
            locationService.deallocate(houseID, auxiliaryService.getAuxiliary(auxiliaryID));
        } catch (NotFoundException e) {
            System.out.println(e);
        }
    }

    public void stopUse(String houseID, String auxiliaryID) {
        try {
            auxiliaryService.use(auxiliaryID);
            locationService.deallocate(houseID, auxiliaryService.getAuxiliary(auxiliaryID));
        } catch (NotFoundException e) {
            System.out.println(e);
        }
    }

    public void repair(String auxiliaryID) {
        try {
            auxiliaryService.repair(auxiliaryID);
        } catch (NotFoundException e) {
            System.out.println(e);
        }
    }

}
