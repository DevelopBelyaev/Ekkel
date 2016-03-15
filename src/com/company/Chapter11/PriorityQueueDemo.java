package com.company.Chapter11;

import java.util.*;

/**
 * Created by oleg on 13.03.16.
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue<>();
        Random random = new Random(44);
        for (int i = 0; i < 10; i++) {
            integerPriorityQueue.offer(random.nextInt(i + 10));
        }
        integerPriorityQueue.forEach(System.out::println);

        System.out.println("DEmo 2");
        List<Integer> integers = Arrays.asList(22, 33, 55, 41, 36, 85, 235, 98, 47, 12, 31, 10, 10, 13, 88, 99, 44, 77,
                75, 58, 96, 32, 16);
        integers.sort(Integer::compareTo);
        integerPriorityQueue = new PriorityQueue<>(integers);
        System.out.println("Demo 3");
        integerPriorityQueue.forEach(System.out::println);
        integerPriorityQueue = new PriorityQueue<>(integers.size(), Collections.reverseOrder());
        integerPriorityQueue.addAll(integers);
        System.out.println("Demo 4");
        integerPriorityQueue.forEach(System.out::println);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String fact = "EDUCATION SHOULD ESCHEW  OBFUSCATION";
        List<String> strings = Arrays.asList(fact.split(""));
        PriorityQueue<String> stringPriorityQueue = new PriorityQueue<>(strings);
        System.out.println("String PQ");
        stringPriorityQueue.forEach(System.out::println);
        stringPriorityQueue = new PriorityQueue<>(strings.size(), Collections.reverseOrder());
        stringPriorityQueue.addAll(strings);
        System.out.println("String PQ reverse order");
        stringPriorityQueue.forEach(System.out::println);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Set<Character> charSet = new HashSet<>();
        for (char c : fact.toCharArray()) {
            charSet.add(c);
        }

        PriorityQueue<Character> characterPriorityQueue = new PriorityQueue<>(charSet);
        System.out.println("Char PQ");
        characterPriorityQueue.forEach(System.out::println);

    }
}
