package com.company.Chapter11;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by oleg on 13.03.16.
 */
public class SimpleCollections {
    public static void main(String[] args) {
        Collection<Integer> integerCollection = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            integerCollection.add(i);
        }
        integerCollection.forEach(System.out::println);
    }
}
