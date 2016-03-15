package com.company.Chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by oleg on 13.03.16.
 */
public class SimpleCollections {
    static <T> void test(Iterable<T> ts) {
        for (T t : ts) {
            System.out.println(t);
        }
    }
    public static void main(String[] args) {
        Collection<Integer> integerCollection = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            integerCollection.add(i);
        }
        integerCollection.forEach(System.out::println);
        int[] array = {1, 2, 3};
        test(Arrays.asList(array));
    }
}
