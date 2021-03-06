package cz.cvut.fel.smarthome.model.repository;

import cz.cvut.fel.smarthome.model.basic.AbstractEntity;
import cz.cvut.fel.smarthome.model.repository.interfaces.CrudRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public abstract class AbstractContextRepo<ID, T extends AbstractEntity<ID>> implements CrudRepository<ID, T> {

    protected Set<T> pool;

    //to override
    public AbstractContextRepo() {
        pool = new HashSet<>();
    }

    @Override
    public T create(T entity) {
        pool.add(entity);
        return entity;
    }

    @Override
    public T update(T entity) {
        pool.remove(entity);
        pool.add(entity);
        return entity;
    }

    @Override
    public void delete(ID id) {
        Optional<T> temp = pool.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst();
        temp.ifPresent(pool::remove);
    }

    @Override
    public Optional<T> find(ID id) {
        return pool.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst();
    }

    @Override
    public Collection<T> findAll() {
        return pool;
    }
}
