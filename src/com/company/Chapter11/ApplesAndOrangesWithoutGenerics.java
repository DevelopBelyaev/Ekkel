package com.company.Chapter11;

import java.util.ArrayList;

/**
 * Created by oleg on 13.03.16.
 */
class Apple {
    private static long counter = 0;
    protected final long id = counter++;

    public long getId() {
        return id;
    }
}

class Orange {

}

class GrannySmith extends Apple {
}

class Gala extends Apple {
}

class Fuji extends Apple {
}

class Braeburn extends Apple {
}

public class ApplesAndOrangesWithoutGenerics {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList();
        for (int i = 0; i < 30; i++) {
            switch (i % 5) {
                case 0: {
                    apples.add(new Apple());
                    break;
                }
                case 1: {
                    apples.add(new GrannySmith());
                    break;
                }
                case 2: {
                    apples.add(new Gala());
                    break;
                }
                case 3: {
                    apples.add(new Fuji());
                    break;
                }
                case 4: {
                    apples.add(new Braeburn());
                    break;
                }
                default: {
                    break;
                }
            }
        }
        for (Apple apple :
                apples) {
            System.out.println(apple.getId());
            System.out.println(apple);
        }
    }
}

