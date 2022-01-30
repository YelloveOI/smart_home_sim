package cz.cvut.fel.smarthome;

import cz.cvut.fel.smarthome.simpleDI.DICompositionPoint;
import cz.cvut.fel.smarthome.simpleDI.context.ApplicationContext;
import lombok.SneakyThrows;

public class SemOmo {

    public static void main(String[] args) {
        DICompositionPoint compositionPoint = new DICompositionPoint();
        ApplicationContext context = compositionPoint.run();

        Configurator configurator = context.getBean(Configurator.class);
        configurator.config2("SMART_HOME");

        Simulator simulator = context.getBean(Simulator.class);
        simulator.start(100);

    }
}
