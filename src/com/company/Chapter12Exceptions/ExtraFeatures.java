package com.company.Chapter12Exceptions;

import java.util.Random;

/**
 * Created by oleg on 15.03.16.
 */
class MyException2 extends Exception {
    private int x;

    public MyException2() {

    }

    public MyException2(String msg) {
        super(msg);
    }

    public MyException2(String msg, int x) {
        super(msg);
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public String getMessage() {
        return "Detailed message " + x + "  " + super.getMessage();
    }
}

public class ExtraFeatures {
    public static void f() throws MyException2 {
        System.out.println("MyException2 in f()");
        throw new MyException2();
    }
    public static void g() throws MyException2 {
        System.out.println("MyException2 in g()");
        throw new MyException2("throws in g()");
    }
    public static void h() throws MyException2 {
        System.out.println("MyException2 in h()");
        throw new MyException2("throws in h()", new Random().nextInt());
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException2 myException2) {
            myException2.printStackTrace(System.out);
        }
        try {
            g();
        } catch (MyException2 myException2) {
            myException2.printStackTrace(System.out);
        }
        try {
            h();
        } catch (MyException2 myException2) {
            myException2.printStackTrace(System.out);
            System.out.println("e.val() = " + myException2.getX());
        }
    }
}
