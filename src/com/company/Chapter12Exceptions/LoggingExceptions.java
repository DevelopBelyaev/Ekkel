package com.company.Chapter12Exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * Created by oleg on 15.03.16.
 */
class LoggingException extends Exception {
    private static Logger logger = Logger.getLogger("LoggingException");

    public LoggingException() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}

public class LoggingExceptions {
    public static void main(String[] args) {
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.print("Перехвачено" + e);
            System.out.println();
        }
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.print("Перехвачено" + e);

        }
    }
}
