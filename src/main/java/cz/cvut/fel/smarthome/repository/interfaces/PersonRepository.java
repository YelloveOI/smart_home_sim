package cz.cvut.fel.smarthome.repository.interfaces;

import cz.cvut.fel.smarthome.model.entities.movable.Alive;

import java.util.Optional;

public interface PersonRepository extends CrudRepository<String, Alive> {

    Optional<Alive> findRandomByIsFree();

}
