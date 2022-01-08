package cz.cvut.fel.smarthome.repository;

import cz.cvut.fel.smarthome.model.actors.Pet;

public class PetRepository extends AbstractRepository<String, Pet> {

    public Pet create(Pet pet) {
        return super.create(pet.getName(), pet);
    }

    public Pet update(Pet pet) {
        return super.update(pet.getName(), pet);
    }

}
