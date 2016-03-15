package com.company.Chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by oleg on 15.03.16.
 */
public class ModifyingArrayList {
    public static void main(String[] args) {
        Random random = new Random(99);
        Integer[] integers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> list = new ArrayList<>(Arrays.asList(integers));
    }
}
