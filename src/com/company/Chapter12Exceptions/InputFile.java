package com.company.Chapter12Exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by oleg on 17.03.16.
 */
public class InputFile {
    private BufferedReader in;
    public InputFile(final String name) throws Exception {
        try {
            in = new BufferedReader(new FileReader(name));
        } catch (FileNotFoundException e) {
            System.out.println("Could open " + name);
            throw e;
        } catch (Exception e) {
            try {
                in.close();
            } catch (IOException e1) {
                System.out.println("failed to close the file");
            }
        } finally {

        }
    }

    public String getLine() {
        String s;
        try {
            s = in.readLine();
        } catch (IOException e) {
            throw  new RuntimeException(" readLine It performed poorly");
        }
        return s;
    }

    public void dispose() {
        try {
            in.close();
        } catch (IOException e) {
            throw new RuntimeException("in.close() it performed poorly");
        }
    }


}
