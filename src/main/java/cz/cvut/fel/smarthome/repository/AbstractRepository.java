package cz.cvut.fel.smarthome.repository;

import cz.cvut.fel.smarthome.model.exception.PersistenceException;
import cz.cvut.fel.smarthome.repository.interfaces.CrudRepository;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractRepository <ID, T> implements CrudRepository<ID, T> {

    protected Map<ID, T> repo = new ConcurrentHashMap<>();

    public T create(ID id, T entity) {
        Objects.requireNonNull(entity);
        if(repo.containsKey(id)) throw new PersistenceException("Entity " + entity + " already exists");
        repo.put(id, entity);
        return entity;
    }

    public T update(ID id, T entity) {
        Objects.requireNonNull(entity);
        if(!repo.containsKey(id)) throw new PersistenceException("Entity " + entity + " does not exist");
        repo.replace(id, entity);
        return entity;
    }

    public void delete(ID id) {
        Objects.requireNonNull(id);
        if(!repo.containsKey(id)) throw new PersistenceException("Entity with id " + id + " does not exist");
        repo.remove(id);
    }

    public T find(ID id) {
        Objects.requireNonNull(id);
        if(!repo.containsKey(id)) throw new PersistenceException("Entity with id " + id + " does not exist");
        return repo.get(id);
    }

    public Collection<T> findAll() {
        return repo.values();
    }
}
