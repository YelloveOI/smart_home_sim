package cz.cvut.fel.smarthome.simpleDI.factory;

import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;
import cz.cvut.fel.smarthome.simpleDI.config.Configuration;
import cz.cvut.fel.smarthome.simpleDI.config.JavaConfiguration;
import cz.cvut.fel.smarthome.simpleDI.configurator.BeanConfigurator;
import cz.cvut.fel.smarthome.simpleDI.configurator.JavaBeanConfigurator;
import cz.cvut.fel.smarthome.simpleDI.context.ApplicationContext;
import lombok.SneakyThrows;


import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BeanFactory {

    private final BeanConfigurator beanConfigurator;
    private final Configuration configuration;
    private final ApplicationContext context;

    public BeanFactory(ApplicationContext applicationContext) {
        this.context = applicationContext;
        this.configuration = new JavaConfiguration();
        this.beanConfigurator = new JavaBeanConfigurator(configuration.getPackageToScan(), configuration.getInterfaceToImplementation());
    }

    @SneakyThrows
    public <T> T getBean(Class<T> clazz) {
        Class<? extends T> implementationClass = clazz;
        if(implementationClass.isInterface()) {
            implementationClass = beanConfigurator.getImplementationClass(implementationClass);
        }

        T bean = implementationClass.getDeclaredConstructor().newInstance();
        for(Field f : Arrays
                .stream(implementationClass.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Inject.class))
                .collect(Collectors.toList())) {
            f.setAccessible(true);
            f.set(bean, context.getBean(f.getType()));
        }
        return bean;
    }

}
