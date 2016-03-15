package com.company.Chapter10.InnerClasses;

/**
 * Created by oleg on 12.03.16.
 */
public class Parcel3 {
    public static void main(String[] args) {
        Parcel3 parcel3 = new Parcel3();
        Parcel3.Contents contents = parcel3.new Contents();
        Parcel3.Destination destination = parcel3.new Destination("test");
    }

    class Contents {
        private int value = 11;

        public int getValue() {
            return value;
        }
    }

    class Destination {
        private String label;

        Destination(final String whereTo) {
            label = whereTo;
            System.out.println(label);
        }

        public String getLabel() {
            return label;
        }
    }
}
