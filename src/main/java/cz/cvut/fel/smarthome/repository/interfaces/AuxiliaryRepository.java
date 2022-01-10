package cz.cvut.fel.smarthome.repository.interfaces;

import cz.cvut.fel.smarthome.model.auxiliary.Auxiliary;
import cz.cvut.fel.smarthome.model.auxiliary.AuxiliaryType;

import java.util.Optional;

public interface AuxiliaryRepository extends CrudRepository<String, Auxiliary> {

    public Optional<Auxiliary> findFirstByDestinyAndByAvailable(AuxiliaryType type);

}
