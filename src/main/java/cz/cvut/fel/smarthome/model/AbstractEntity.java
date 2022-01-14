package cz.cvut.fel.smarthome.model;

import java.util.Objects;

public class AbstractEntity {

    protected final String name;
    protected String roomName;

    public AbstractEntity(String name) {
        this.name = name;
        this.roomName = "Outside";
    }

    public String getRoomName() {
        return roomName;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractEntity that = (AbstractEntity) o;

        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
