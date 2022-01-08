package cz.cvut.fel.smarthome.repository;

import cz.cvut.fel.smarthome.model.auxiliary.Auxiliary;
import cz.cvut.fel.smarthome.model.auxiliary.AuxiliaryType;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class AuxiliaryRepository extends AbstractRepository<String, Auxiliary> {

    public Set<Auxiliary> findAllByType(AuxiliaryType type) {
        Objects.requireNonNull(type);
        return repo.values().stream()
                .filter(v -> Objects.equals(v.getType(), type))
                .collect(Collectors.toSet());
    }

}
