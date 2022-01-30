package cz.cvut.fel.smarthome.simpleDI;

import cz.cvut.fel.smarthome.simpleDI.context.ApplicationContext;
import cz.cvut.fel.smarthome.simpleDI.factory.BeanFactory;

/**
 * Composes DI container in a right way
 */
public class DICompositionPoint {
    public ApplicationContext context;

    public ApplicationContext run() {
        ApplicationContext context = new ApplicationContext();
        BeanFactory beanFactory = new BeanFactory(context);
        context.setBeanFactory(beanFactory);

        return context;
    }
}
