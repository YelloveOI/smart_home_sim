package cz.cvut.fel.smarthome.repository.interfaces;

import java.util.Collection;
import java.util.Optional;

public interface CrudRepository<ID, T> {

    T create(T entity);

    T update(T entity);

    void delete(ID id);

    Optional<T> find(ID id);

    Collection<T> findAll();

}
