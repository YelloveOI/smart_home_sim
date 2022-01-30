package cz.cvut.fel.smarthome.simpleDI.context;

import cz.cvut.fel.smarthome.simpleDI.factory.BeanFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Spring-like application context
 */
public class ApplicationContext {

    private BeanFactory beanFactory;
    private final Map<Class, Object> beanMap = new ConcurrentHashMap<>();

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    /**
     *  Gets bean from context, if it doesn't exist creates it
     *  (for Singleton scope)
     */
    public <T> T getBean(Class<T> clazz) {
        if(clazz == ApplicationContext.class) {
            return (T) this;
        }

        if(beanMap.containsKey(clazz)) {
            return (T) beanMap.get(clazz);
        }

        T bean = beanFactory.getBean(clazz);

        beanMap.put(clazz, bean);

        return bean;
    }

    /**
     * Creates a new bean (for Prototype scope)
     */
    public <T> T getNewBean(Class<T> clazz) {
        T bean = beanFactory.getBean(clazz);

        if(!beanMap.containsKey(clazz)) {
            beanMap.put(clazz, bean);
        }

        return beanFactory.getBean(clazz);
    }

}
