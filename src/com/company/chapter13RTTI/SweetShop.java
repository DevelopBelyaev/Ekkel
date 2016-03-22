package com.company.chapter13RTTI;

/**
 * Created by oleg on 21.03.16.
 */
class Candy {
    static {
        System.out.println("loading the class Candy");
    }
}

class Gum {
    static {
        System.out.println("loading the class Gum");
    }
}

class Cookie {
    static {
        System.out.println("loading the class Cookie");
    }
}

public class SweetShop {
    public static void main(String[] args) {
        System.out.println("in to main method");
        new Candy();
        System.out.println("after creating Candy object");

        try {

            Class.forName("Gum");
        } catch (ClassNotFoundException e) {
            System.out.println("class Gum not found");
        }
        System.out.println("after calling a method's Class.forName(\"Gum\") ");
        new Cookie();
    }
}
