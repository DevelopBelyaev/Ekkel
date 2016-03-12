package com.company.Chapter10.InnerClasses;

/**
 * Created by oleg on 12.03.16.
 */
public class Parcel6 {
    private void internalTracking(boolean b) {
        if (b) {
            class TrackingShip {
                private String ship;

                TrackingShip(String s) {
                    ship = s;
                    System.out.println(ship);
                }

                public String getShip() {
                    return ship;
                }
            }
            TrackingShip trackingShip = new TrackingShip("wait");
            String s = trackingShip.getShip();
        }
    }

    public void track() {
        internalTracking(true);
    }

    public static void main(String[] args) {
        Parcel6 parcel6 = new Parcel6();
        parcel6.track();
    }
}
