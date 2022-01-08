package cz.cvut.fel.smarthome.model.actors;

import java.util.Objects;

public class Person {

    private final String name;
    private PersonRoleType role;

    public Person(String name, PersonRoleType role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public PersonRoleType getRole() {
        return role;
    }

    public void setRole(PersonRoleType role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
