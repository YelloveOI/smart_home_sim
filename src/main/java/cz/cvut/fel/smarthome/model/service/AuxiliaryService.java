package cz.cvut.fel.smarthome.model.service;

import cz.cvut.fel.smarthome.model.entities.State;
import cz.cvut.fel.smarthome.model.entities.auxiliary.AbstractAuxiliary;
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

    public Boolean use(String auxiliaryID) throws NotFoundException {
        AbstractAuxiliary auxiliary = getAuxiliary(auxiliaryID);
        Boolean result = auxiliary.use();
        repo.update(auxiliary);

        return result;
    }

    public Boolean stopUse(String auxiliaryID) throws NotFoundException {
        AbstractAuxiliary auxiliary = getAuxiliary(auxiliaryID);
        Boolean result = auxiliary.stopUse();
        repo.update(auxiliary);

        return result;
    }

    public void repair(String auxiliaryID) throws NotFoundException {
        AbstractAuxiliary auxiliary = getAuxiliary(auxiliaryID);
        auxiliary.repair();
        repo.update(auxiliary);
    }

}
