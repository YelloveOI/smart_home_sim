package cz.cvut.fel.smarthome;

import com.google.gson.Gson;
import cz.cvut.fel.smarthome.model.entities.movable.Person;
import cz.cvut.fel.smarthome.repository.interfaces.SimpleDeviceRepository;
import cz.cvut.fel.smarthome.service.Configurator;
import cz.cvut.fel.smarthome.service.Simulator;
import cz.cvut.fel.smarthome.simpleDI.DICompositionPoint;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;
import cz.cvut.fel.smarthome.simpleDI.context.ApplicationContext;
import lombok.SneakyThrows;

public class SemOmo {

    @SneakyThrows
    public static void main(String[] args) {
        DICompositionPoint compositionPoint = new DICompositionPoint();
        ApplicationContext context = compositionPoint.run();

        Configurator configurator = context.getBean(Configurator.class);
        configurator.config1();

    }
}
