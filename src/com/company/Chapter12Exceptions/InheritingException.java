package com.company.Chapter12Exceptions;

/**
 * Created by oleg on 15.03.16.
 */

class SimpleException extends Exception {}
public class InheritingException {
    public void f() throws SimpleException {
        System.out.println("throw SimpleException in f()");
        throw new SimpleException();
    }

    public static void main(String[] args) {
        InheritingException exception = new InheritingException();
        try {
            exception.f();
        } catch (SimpleException e) {
            System.out.println("перехват");
        }
    }
}
