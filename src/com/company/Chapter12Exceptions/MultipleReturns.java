package com.company.Chapter12Exceptions;

/**
 * Created by oleg on 17.03.16.
 */

public class MultipleReturns {
    public static void f(final int i) {
        System.out.println("initialization, requires the completion of");
        try {
            System.out.println("point 1");
            if (i == 1) {
                return;
            }
            System.out.println("point 2");
            if (i == 2) {
                return;
            }
            System.out.println("point 3");
            if (i == 3) {
                return;
            }
            System.out.println("end");
            return;
        } finally {
            System.out.println("completion");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            f(i);
        }
    }
}
