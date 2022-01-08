package cz.cvut.fel.smarthome.repository;

import cz.cvut.fel.smarthome.model.auxiliary.Auxiliary;
import cz.cvut.fel.smarthome.model.enums.AuxiliaryDestinyType;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class AuxiliaryRepository extends AbstractRepository<String, Auxiliary> {

    public Set<Auxiliary> findAllByDestiny(AuxiliaryDestinyType type) {
        Objects.requireNonNull(type);
        return repo.values().stream()
                .filter(v -> Objects.equals(v.getDestiny(), type))
                .collect(Collectors.toSet());
    }

}
