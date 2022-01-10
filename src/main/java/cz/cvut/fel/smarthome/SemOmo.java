package cz.cvut.fel.smarthome;

import cz.cvut.fel.smarthome.model.auxiliary.Auxiliary;
import cz.cvut.fel.smarthome.model.auxiliary.AuxiliaryType;
import cz.cvut.fel.smarthome.model.location.House;
import cz.cvut.fel.smarthome.simpleDI.DICompositionPoint;
import cz.cvut.fel.smarthome.simpleDI.context.ApplicationContext;
import lombok.SneakyThrows;

public class SemOmo {
    @SneakyThrows
    public static void main(String[] args) {
        DICompositionPoint compositionPoint = new DICompositionPoint();
        ApplicationContext context = compositionPoint.run();

        House house = new House("Happy Home", 2)
                .addGarage("G1", 0)
                .addRoom("Room1", 0, 2)
                .addRoom("Room2", 1, 3);

        System.out.println(house);

        Auxiliary auxiliary = new Auxiliary("BIKE", AuxiliaryType.SPORT);
        auxiliary.startUse();
    }
}
