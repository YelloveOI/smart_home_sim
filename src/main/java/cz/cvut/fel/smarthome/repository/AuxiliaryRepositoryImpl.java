package cz.cvut.fel.smarthome.repository;

import cz.cvut.fel.smarthome.model.entities.auxiliary.AbstractAuxiliary;
import cz.cvut.fel.smarthome.repository.interfaces.AuxiliaryRepository;

import java.util.Objects;
import java.util.Optional;
import java.util.Random;

public class AuxiliaryRepositoryImpl extends AbstractRepo<String, AbstractAuxiliary> implements AuxiliaryRepository {

    @Override
    public Optional<AbstractAuxiliary> findRandomCarByIsAvailable() {
        Random rnd = new Random();

        return pool.stream()
                .filter(v -> v.getId().contains("CAR_"))
                .filter(AbstractAuxiliary::isAvailable).min((v1, v2) -> {
                    if (Objects.equals(v1, v2)) return 0;
                    return (rnd.nextBoolean()) ? 1 : -1;
                });
    }
}
