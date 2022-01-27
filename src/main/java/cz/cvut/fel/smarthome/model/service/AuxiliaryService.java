package cz.cvut.fel.smarthome.model.service;

import cz.cvut.fel.smarthome.model.entities.State;
import cz.cvut.fel.smarthome.model.entities.auxiliary.AbstractAuxiliary;
import cz.cvut.fel.smarthome.model.exception.IllegalUseException;
import cz.cvut.fel.smarthome.model.repository.interfaces.AuxiliaryRepository;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;
import javassist.NotFoundException;

import java.util.Optional;

public class AuxiliaryService {

    @Inject
    private AuxiliaryRepository repo;

    public AbstractAuxiliary getAuxiliary(String auxiliaryID) throws NotFoundException {
        Optional<AbstractAuxiliary> auxiliary = repo.find(auxiliaryID);

        if(auxiliary.isEmpty()) {
            throw new NotFoundException("Can't find auxiliary with id: " + auxiliaryID);
        }

        return auxiliary.get();
    }

    public void use(String auxiliaryID) throws NotFoundException, IllegalUseException {
        AbstractAuxiliary auxiliary = getAuxiliary(auxiliaryID);

        if(!auxiliary.use()) {
            throw new IllegalUseException("Can't use auxiliary " + auxiliaryID + " it's not available or broken");
        }

        repo.update(auxiliary);
    }

    public void stopUse(String auxiliaryID) throws NotFoundException, IllegalUseException {
        AbstractAuxiliary auxiliary = getAuxiliary(auxiliaryID);

        if(!auxiliary.stopUse()) {
            throw new IllegalUseException("Can't use auxiliary " + auxiliaryID + " because it's broken");
        }

        repo.update(auxiliary);
    }

    public void repair(String auxiliaryID) throws NotFoundException {
        AbstractAuxiliary auxiliary = getAuxiliary(auxiliaryID);
        auxiliary.repair();
        repo.update(auxiliary);
    }

}
