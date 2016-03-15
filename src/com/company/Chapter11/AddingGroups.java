package com.company.Chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by oleg on 13.03.16.
 */
public class AddingGroups {
    static int f(int i) {
        i *= i;
        return i;
    }

    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreIntegers = {6, 7, 8, 9, 10};
        collection.addAll(Arrays.asList(moreIntegers));
        Collections.addAll(collection, 11, 12, 13, 14, 15);
        Collections.addAll(collection, moreIntegers);
        Collections.addAll(collection, 16, 17, 18, 19, 20);
        collection.forEach(AddingGroups::f);
        collection.forEach(System.out::println);
    }
}
