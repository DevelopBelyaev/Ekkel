package com.company.Chapter12Exceptions;

/**
 * Created by oleg on 17.03.16.
 */
public class ExceptionSilencer {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } finally {
            return;
        }
    }
}
