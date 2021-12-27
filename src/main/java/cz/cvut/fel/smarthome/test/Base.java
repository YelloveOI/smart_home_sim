package cz.cvut.fel.smarthome.test;

import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

public class Base {

    @Inject
    private A a;

    @Inject
    private B b;

    @Inject(implType = Impl2.class)
    private Inter inter;

    public Base() {
    }

    public Base(A a, B b, Inter inter) {
        this.a = a;
        this.b = b;
        this.inter = inter;
    }

    public void foo() {
        System.out.println(a.bar());
        b.bar();
        inter.dooFoo();
    }

}
