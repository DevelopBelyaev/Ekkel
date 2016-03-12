
package com.company.Chapter10.InnerClasses;

/**
 * Created by oleg on 12.03.16.
 */
public class Parcel10 {
    //demonstration initialization copy for creating unnamed inner class
    public Destination destination(final String dest, final float price) {
            return new Destination() {
                private int cost;
                {//initialization for each object
                    cost = Math.round(price);
                    if (cost > 100) {
                        System.out.println("exceeding the budget");
                    }
                }
                private String  label = dest;
                @Override
                public String readLabel() {
                    return label;
                }
            };
    }

    public static void main(String[] args) {
        Parcel10 parcel10 = new Parcel10();
        Destination destination = parcel10.destination("test", 101_999);
    }
}
