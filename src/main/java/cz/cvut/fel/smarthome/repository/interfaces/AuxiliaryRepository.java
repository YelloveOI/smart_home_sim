package cz.cvut.fel.smarthome.repository.interfaces;

import cz.cvut.fel.smarthome.model.entities.auxiliary.Auxiliary;
import cz.cvut.fel.smarthome.model.entities.auxiliary.AuxiliaryType;

import java.util.Optional;

public interface AuxiliaryRepository extends CrudRepository<String, Auxiliary> {

    Optional<Auxiliary> findFirstByDestinyAndByAvailable(AuxiliaryType type);

}
