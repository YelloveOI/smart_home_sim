package cz.cvut.fel.smarthome;

import cz.cvut.fel.smarthome.controller.PersonRoutineController;
import cz.cvut.fel.smarthome.simpleDI.DICompositionPoint;
import cz.cvut.fel.smarthome.simpleDI.context.ApplicationContext;
import lombok.SneakyThrows;

public class SemOmo {

    @SneakyThrows
    public static void main(String[] args) {
        DICompositionPoint compositionPoint = new DICompositionPoint();
        ApplicationContext context = compositionPoint.run();

        Configurator configurator = context.getBean(Configurator.class);
        configurator.config1();

//        PersonRoutineController personRoutineController = context.getBean(PersonRoutineController.class);
//        personRoutineController.goProcrastinate("SMART_HOUSE", "PERSON_Ivan", "TV_tv1");

    }
}
