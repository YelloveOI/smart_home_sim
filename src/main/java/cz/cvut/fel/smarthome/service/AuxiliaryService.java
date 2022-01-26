package cz.cvut.fel.smarthome.service;

import cz.cvut.fel.smarthome.model.entities.auxiliary.AbstractAuxiliary;
import cz.cvut.fel.smarthome.repository.interfaces.AuxiliaryRepository;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;
import javassist.NotFoundException;

import java.util.Optional;

public class AuxiliaryService {

    @Inject
    private AuxiliaryRepository auxiliaryRepository;
    @Inject
    private LocatorService locatorService;

    private AbstractAuxiliary getAuxiliary(String auxiliaryID) throws NotFoundException {
        Optional<AbstractAuxiliary> auxiliary = auxiliaryRepository.find(auxiliaryID);

        if(auxiliary.isEmpty()) {
            throw new NotFoundException("Can't find auxiliary with id: " + auxiliaryID);
        }

        return auxiliary.get();
    }

    public Boolean use(String auxiliaryID) throws NotFoundException {
        AbstractAuxiliary auxiliary = getAuxiliary(auxiliaryID);

        return auxiliary.use();
    }

    public Boolean stopUse(String auxiliaryID) throws NotFoundException {
        AbstractAuxiliary auxiliary = getAuxiliary(auxiliaryID);

        return auxiliary.stopUse();
    }


}
