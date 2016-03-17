package com.company.Chapter12Exceptions;

/**
 * Created by oleg on 16.03.16.
 */

/**
 * the finally unit of work demonstration
 */
class Switch {
    private boolean state = false;

    public boolean read() {
        return state;
    }

    public void on() {
        state = true;
        System.out.println(this);
    }

    public void off() {
        state = false;
        System.out.println(this);
    }

    public String toString() {
        return state == true ? "on" : "off";
    }
}

class OnOffException1 extends Exception {

}

class OnOffException2 extends Exception {

}

public class OnOfSwitch {
    private static Switch aSwitch = new Switch();

    static void f() throws OnOffException1, OnOffException2 {

    }

    public static void main(String[] args) {

        try {
            aSwitch.on();
            f();
            aSwitch.off();
        } catch (OnOffException1 onOffException1) {
            System.out.println("OnOffException1");
            aSwitch.off();
        } catch (OnOffException2 onOffException2) {
            System.out.println("OnOffException2");
            aSwitch.off();
        } finally {
            aSwitch.off();//Calling this method is guaranteed
        }

    }
}
