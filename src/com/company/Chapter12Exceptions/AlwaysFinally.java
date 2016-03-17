package com.company.Chapter12Exceptions;

/**
 * Created by oleg on 16.03.16.
 */
class FourException extends Exception{}
public class AlwaysFinally {
    public static void main(String[] args) {
        System.out.println("Enter the first block try");
        try {
            System.out.println("Enter the second block try");
            try {
                throw new FourException();
            } finally {
                System.out.println("finally in second try block");
            }
        } catch (FourException e) {
            System.out.println("exception intercepted in the first block try");
        } finally {
            System.out.println("finally in first try block");
        }
    }
}
