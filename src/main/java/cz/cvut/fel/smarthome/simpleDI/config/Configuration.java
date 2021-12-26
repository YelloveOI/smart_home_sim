package cz.cvut.fel.smarthome.simpleDI.config;

import java.util.Map;

public interface Configuration {

    String getPackageToScan();

    Map<Class, Class> getInterfaceToImplementation();

}
