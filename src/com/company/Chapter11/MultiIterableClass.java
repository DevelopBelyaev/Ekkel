package com.company.Chapter11;

import java.util.*;

/**
 * Created by oleg on 15.03.16.
 */
public class MultiIterableClass extends IterableClass {
    public Iterable<String> reversed() {
        return () -> new Iterator<String>() {
            int current = words.length - 1;
            @Override
            public boolean hasNext() {
                return current > -1;
            }

            @Override
            public String next() {
                return words[current--];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public Iterable<String> randomized() {
        return () -> {
            List<String> shuffled = new ArrayList<>(Arrays.asList(words));
            Collections.shuffle(shuffled, new Random(hashCode()));
            return shuffled.iterator();
        };
    }

    public static void main(String[] args) {
        MultiIterableClass multiIterableClass = new MultiIterableClass();
        for (String s : multiIterableClass.reversed()) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (String s:
             multiIterableClass.randomized()) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
