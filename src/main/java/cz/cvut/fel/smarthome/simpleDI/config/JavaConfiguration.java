package cz.cvut.fel.smarthome.simpleDI.config;

import java.util.HashMap;
import java.util.Map;

public class JavaConfiguration implements Configuration {

    @Override
    public String getPackageToScan() {
        return "cz.cvut.fel.smarthome";
    }

    @Override
    public Map<Class, Class> getInterfaceToImplementation() {
        return new HashMap<>();
    }
}
