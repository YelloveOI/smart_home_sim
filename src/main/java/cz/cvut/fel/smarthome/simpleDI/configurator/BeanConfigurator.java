package cz.cvut.fel.smarthome.simpleDI.configurator;

public interface BeanConfigurator {

    <T> Class<? extends T> getImplementationClass(Class<T> interfaceClass);

}
