package com.company.Chapter12Exceptions;

/**
 * Created by oleg on 16.03.16.
 */

class ThreeException extends Exception{}
public class FinallyWorks {
    static int count = 0 ;

    public static void main(String[] args) {
        while (true) {
            try {
                if (count++ == 0) {//postfix increment operation
                    throw new ThreeException();
                }
                System.out.println("not exception");
            } catch (ThreeException e) {
                System.out.println("ThreeException");
            } finally {
                System.out.println("in finally block");
                if (count == 2) {
                    break;//outside the loop
                }
            }
        }
    }
}
