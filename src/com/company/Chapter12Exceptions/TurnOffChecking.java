package com.company.Chapter12Exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by oleg on 17.03.16.
 */
class WrapCheckingException {
    void throwRuntimeException(final int type) {
        try {
            switch (type) {
                case 0:
                    throw new FileNotFoundException();
                case 1:
                    throw new IOException();
                case 2:
                    throw new RuntimeException("where i am?");
                default:
                    return;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class SomeOtherException extends Exception {

}


public class TurnOffChecking {
    public static void main(String[] args) {
        WrapCheckingException wce = new WrapCheckingException();
        //you can call method without try block
        // and allow intercepted RuntimeException to leave the method
        wce.throwRuntimeException(3);
        // or interrupt exception
        try {


            for (int i = 0; i < 4; i++) {
                if (i < 3) {
                    wce.throwRuntimeException(i);
                } else {
                    throw new SomeOtherException();
                }
            }
        } catch (SomeOtherException e) {
            System.out.println("SomeOtherException" + e);
        } catch (RuntimeException e) {
            try {
                throw e.getCause();
            } catch (FileNotFoundException e1) {
                System.out.println("FileNotFoundException");
            } catch (IOException e1) {
                System.out.println("IOException");
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }
}
