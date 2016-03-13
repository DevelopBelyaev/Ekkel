package com.company.Chapter10.InnerClasses;

/**
 * Created by oleg on 13.03.16.
 */
public interface ClassInterface {
    void howdy(String s);

    class Test implements ClassInterface {

        @Override
        public void howdy(String s) {
            System.out.println(s);
        }

        public static void main(String[] args) {
            new Test().howdy("Hello");
        }
    }
}
