package cz.cvut.fel.smarthome.repository.interfaces;

import java.util.Collection;

public interface CrudRepository<ID, T> {

    T create(ID id, T entity);

    T update(ID id, T entity);

    void delete(ID id);

    T find(ID id);

    Collection<T> findAll();

}
