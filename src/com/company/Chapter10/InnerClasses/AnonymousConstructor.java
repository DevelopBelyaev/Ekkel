package com.company.Chapter10.InnerClasses;

/**
 * Created by oleg on 12.03.16.
 */
abstract class Base {
    public Base(final int i) {
        System.out.println("Base constructor, i = " + i);
    }

    abstract void f();
}

public class AnonymousConstructor {
    public static Base getBase(final int i) {
        return new Base(i) {
            {
                System.out.println("init copy ");
            }

            @Override
            void f() {
                System.out.println("unnamed f()");
            }
        };
    }

    public static void main(String[] args) {
        Base base = getBase(47);
        base.f();
    }
}
