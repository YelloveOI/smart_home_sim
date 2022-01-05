package cz.cvut.fel.smarthome;

import cz.cvut.fel.smarthome.configurator.HomeConfigurator;
import cz.cvut.fel.smarthome.model.Home;
import cz.cvut.fel.smarthome.simpleDI.DICompositionPoint;
import cz.cvut.fel.smarthome.simpleDI.context.ApplicationContext;
import lombok.SneakyThrows;

public class SemOmo {
    @SneakyThrows
    public static void main(String[] args) {
        DICompositionPoint compositionPoint = new DICompositionPoint();
        ApplicationContext context = compositionPoint.run();

        HomeConfigurator configurator = context.getBean(HomeConfigurator.class);

        Home home = configurator
                .setFloorsQuantity(2)
                .setOwnersQuantity(1)
                .setPlace(0, "room1")
                .setPlace(0, "room2")
                .setPlace(1, "room3")
                .setPlace(1, "room4")
                .build();

        System.out.println(home);

    }
}
