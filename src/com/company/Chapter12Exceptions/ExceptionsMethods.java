package com.company.Chapter12Exceptions;

/**
 * Created by oleg on 15.03.16.
 */
public class ExceptionsMethods {
    public static void main(String[] args) {
        try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println("intercepted");
            System.out.println("getMessage = " + e.getMessage());
            System.out.println("getLocalMessage = " + e.getLocalizedMessage());
            System.out.println("toString = " + e);
            System.out.println("printStackTrace");
            e.printStackTrace(System.out);
        }
    }
}
