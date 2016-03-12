package com.company.Chapter10.InnerClasses;

/**
 * Created by oleg on 08.03.16.
 */
public class DotThis {
    void f() {
        System.out.println("DotThis.f()");
    }

    public class Inner {
        public DotThis outer() {
            return  DotThis.this;
        }
    }
    public Inner inner() {
        return new Inner();
    }

    public static void main(String[] args) {
        DotThis dotThis = new DotThis();
        DotThis.Inner inner = new dotThis.inner();
        inner.outer().f();
    }
}
