package com.company.Chapter10.InnerClasses;

/**
 * Created by oleg on 13.03.16.
 */
class MNA {
    private void f() {
        System.out.println("MNA.f()");
    }

    class A {
        private void g() {
            f();
            System.out.println("MNA.A.g()");
        }

        class B {
            public void h() {
                g();
                f();
                System.out.println("MNA.A.B.h()");
            }
        }
    }
}

public class MultiNestingAccess {
    public static void main(String[] args) {
        MNA mna = new MNA();
        MNA.A a = mna.new A();
        MNA.A.B b = a.new B();
        b.h();
    }
}
