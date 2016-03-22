package com.company.Chapter12Exceptions;

/**
 * Created by oleg on 17.03.16.
 */

class NeedsCleanup {
    private static long counter = 1;
    private final long id = counter++;

    public void dispose() {
        System.out.println("NeedCleanup " + id + " completed");
    }
}

class ConstructionsException extends Exception {
}

class NeedsCleanup2 extends NeedsCleanup {
    NeedsCleanup2() throws ConstructionsException {
    }//possible failures in the construction
}

public class CleanupIdiom {
    public static void main(String[] args) {
        NeedsCleanup needsCleanup = new NeedsCleanup();
        try {
        } finally {
            needsCleanup.dispose();
        }
        //section 2
        // if failures in the construction excluded
        // objects can be grouped
        NeedsCleanup needsCleanup1 = new NeedsCleanup();
        NeedsCleanup needsCleanup2 = new NeedsCleanup();
        try {

        } finally {//reverse order of construction
            needsCleanup2.dispose();
            needsCleanup1.dispose();
        }
        // section 3
        // If possible failures in the design,
        // each object is protected separately
        try {
            NeedsCleanup2 needsCleanup3 = new NeedsCleanup2();
            try {
                NeedsCleanup2 needsCleanup4 = new NeedsCleanup2();
                try {// other code
                } finally {
                    needsCleanup4.dispose();
                }
            } catch (ConstructionsException e) {// needsCleanup4 constructor
            } finally {
                needsCleanup3.dispose();
            }

        } catch (ConstructionsException e) {
            e.printStackTrace(System.out);
            System.out.println(e);
        }
    }
}
