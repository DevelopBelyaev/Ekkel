package com.company.Chapter12Exceptions;

/**
 * Created by oleg on 17.03.16.
 */
public class Cleanup {
    public static void main(String[] args) {
        try {
            InputFile inputFile = new InputFile("/home/oleg/dmes.txt");
            try {
                String s;
                while ((s = inputFile.getLine()) != null) {
                    System.out.println(s);
                }
            } catch (Exception e) {
                System.out.println("intercepted in main ");
                e.printStackTrace(System.out);
            } finally {
                inputFile.dispose();
            }
        } catch (Exception e) {
            System.out.println("failure in the design inputFile object");
        }

    }
}
