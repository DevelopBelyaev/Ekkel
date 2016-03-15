package com.company.Chapter12Exceptions;

/**
 * Created by oleg on 15.03.16.
 */
class MyException extends Exception {
    MyException() {}

    MyException(String msg) {
        super(msg);
    }
}

public class FullConstructors {
    public static void f() throws MyException {
        System.out.println("throw MyException in f()");
        throw new MyException();
    }
    public static void g() throws MyException {
        System.out.println("throw MyException in g()");
        throw new MyException("created in g()");
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            e.printStackTrace(System.err);
        }
        try {
            g();
        } catch (MyException e) {
            e.printStackTrace(System.err);
        }
    }
}
