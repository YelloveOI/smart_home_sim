package cz.cvut.fel.smarthome.model.actor;

public class Person {

    private final String name;
    private PersonRoleType role;
    private boolean isBusy;

    public Person(String name, PersonRoleType role) {
        this.name = name;
        this.role = role;
        this.isBusy = false;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
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

}
