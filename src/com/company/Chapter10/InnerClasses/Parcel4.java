package com.company.Chapter10.InnerClasses;

/**
 * Created by oleg on 12.03.16.
 */
public class Parcel4 {
    public static void main(String[] args) {
        Parcel4 parcel4 = new Parcel4();
        Contents contents = parcel4.contents();
        Destination destination = parcel4.destination();
    }

    public Destination destination() {
        return new PDestination("test");
    }

    public Contents contents() {
        return new PContents();
    }

    private class PContents implements Contents {
        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    private class PDestination implements Destination {
        private String label;

        public PDestination(final String s) {
            label = s;
        }

        @Override
        public String readLabel() {
            return label;
        }
    }

}
