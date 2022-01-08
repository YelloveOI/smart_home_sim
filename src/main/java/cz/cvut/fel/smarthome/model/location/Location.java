package cz.cvut.fel.smarthome.model.location;

import javax.naming.ConfigurationException;
import java.util.ArrayList;
import java.util.List;

public abstract class Location {

    protected final List<Location> nestedLocations = new ArrayList<>();
    protected final Location root;

    public Location() {
        root = null;
    }

    protected Location(Location root) {
        this.root = root;
    }

    public abstract Location addNestedLocation();

    public abstract Location removeNestedLocation(int index);

    public abstract Location getNestedLocation(int index);

    public abstract Location getRoot();

}
