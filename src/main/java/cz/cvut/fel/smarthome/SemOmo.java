package cz.cvut.fel.smarthome;

import cz.cvut.fel.smarthome.simpleDI.DICompositionPoint;
import cz.cvut.fel.smarthome.simpleDI.context.ApplicationContext;
import cz.cvut.fel.smarthome.test.Base;

public class SemOmo {
    public static void main(String[] args) {
        DICompositionPoint compositionPoint = new DICompositionPoint();
        ApplicationContext context = compositionPoint.run();

        Base base = context.getBean(Base.class);
        base.foo();

    }
}
