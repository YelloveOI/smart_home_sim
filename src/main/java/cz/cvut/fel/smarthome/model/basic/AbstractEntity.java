package cz.cvut.fel.smarthome.model.basic;

import java.util.Objects;

/**
 * Represent entity with parametrized ID
 * Used only for persisted layer goals
 * @param <ID>
 */
public abstract class AbstractEntity<ID> {

    protected final ID id;

    public AbstractEntity(ID id) {
        Objects.requireNonNull(id);
        this.id = id;
    }

    public ID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractEntity<?> that = (AbstractEntity<?>) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
