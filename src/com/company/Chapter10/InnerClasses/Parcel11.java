package com.company.Chapter10.InnerClasses;

/**
 * Created by oleg on 13.03.16.
 */
public class Parcel11 {
    public static Destination destination(final String s) {
        return new ParcelDestination(s);
    }

    public static Contents contents() {
        return new PContents();
    }

    public static void main(String[] args) {
        Contents contents = contents();
        Destination destination = destination("test");
    }

    private static class PContents implements Contents {

        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    private static class ParcelDestination implements Destination {

        static int x = 10;
        private String label;

        private ParcelDestination(final String whereTo) {
            label = whereTo;
        }

        public static void f() {
            System.out.println("ParcelDestination f()");
        }

        @Override
        public String readLabel() {
            return label;
        }

        static class AnotherLevel {
            static int x = 10;

            public static void f() {
                System.out.println("AnotherLevel f()");
            }
        }
    }
}
