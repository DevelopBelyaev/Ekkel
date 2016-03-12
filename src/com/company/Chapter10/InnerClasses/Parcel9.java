package com.company.Chapter10.InnerClasses;

/**
 * Created by oleg on 12.03.16.
 */
public class Parcel9 {
    public Destination destination(final String s) {
        return new Destination() {
            private String label = s;
            @Override
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel9 parcel9 = new Parcel9();
        Destination destination = parcel9.destination("test");
    }
}
