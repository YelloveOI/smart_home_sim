package cz.cvut.fel.smarthome.simpleDI.config;

import java.util.HashMap;
import java.util.Map;

/**
 * Spring-like DI configuration
 */
public class JavaConfiguration implements Configuration {

    /**
     * Defines workspace for DI
     */
    @Override
    public String getPackageToScan() {
        return "cz.cvut.fel.smarthome";
    }

    /**
     * Defines preset implementations for interfaces
     */
    @Override
    public Map<Class, Class> getInterfaceToImplementation() {
        return new HashMap<>();
    }
}
