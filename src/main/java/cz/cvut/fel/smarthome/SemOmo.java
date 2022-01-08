package cz.cvut.fel.smarthome;

import cz.cvut.fel.smarthome.model.location.House;
import cz.cvut.fel.smarthome.simpleDI.DICompositionPoint;
import cz.cvut.fel.smarthome.simpleDI.context.ApplicationContext;
import lombok.SneakyThrows;

public class SemOmo {
    @SneakyThrows
    public static void main(String[] args) {
        DICompositionPoint compositionPoint = new DICompositionPoint();
        ApplicationContext context = compositionPoint.run();

        House house = new House();
        house
                .addNestedLocation()
                    .getNestedLocation(0)
                    .addNestedLocation()
                    .addNestedLocation()
                    .addNestedLocation()
                        .getNestedLocation(2)
                        .addNestedLocation()
                        .getRoot()
                    .getRoot()
                .addNestedLocation()
                    .getNestedLocation(1)
                    .addNestedLocation()
                    .addNestedLocation();


    }
}
