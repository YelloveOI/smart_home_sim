package cz.cvut.fel.smarthome.test;

import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

public class Base {

    @Inject
    private A a;

    @Inject
    private B b;

    public Base() {
    }

    public Base(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public void foo() {
        System.out.println(a.bar());
        b.bar();
    }

}
