package com.company.Chapter12Exceptions;

/**
 * Created by oleg on 17.03.16.
 */
class VeryImportantException extends Exception {
    @Override
    public String toString() {
        return "very important exception";
    }
}

class HoHumException extends Exception {
    @Override
    public String toString() {

        return "minor exception";
    }
}

public class LostMessage {
    public static void main(String[] args) {
        try {
            LostMessage lostMessage = new LostMessage();
            try {
                lostMessage.f();
            } finally {
                try {
                    System.out.println("finally");
                    lostMessage.dispose();
                } catch (Exception e) {
                    System.out.println("finally try catch unit");
                    e.printStackTrace(System.out);
                }
            }

        } catch (Exception e) {
            System.out.println("catch");
            System.out.println(e);
        }
    }

    public void f() throws VeryImportantException {
        throw new VeryImportantException();
    }

    public void dispose() throws HoHumException {
        System.out.println("dispose");
        throw new HoHumException();
    }

}
