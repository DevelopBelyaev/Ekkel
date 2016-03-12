package com.company.Chapter10.InnerClasses;

/**
 * Created by oleg on 12.03.16.
 */
public class Parcel8 {
    public Wrapping wrapping(final int x) {
        return new Wrapping(x){
            @Override
            public int getValue() {
                int y = super.getValue() * 47;
                System.out.println("y = " + y);
                return y;
            }
        };
    }

    public static void main(String[] args) {
        Parcel8 parcel8 = new Parcel8();
        Wrapping wrapping = parcel8.wrapping(11);
    }
}
