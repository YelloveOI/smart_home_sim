package cz.cvut.fel.smarthome.repository.interfaces;

import cz.cvut.fel.smarthome.model.entities.auxiliary.AbstractAuxiliary;

import java.util.Optional;

public interface AuxiliaryRepository extends CrudRepository<String, AbstractAuxiliary> {

    Optional<AbstractAuxiliary> findRandomCarByIsAvailable();

}
