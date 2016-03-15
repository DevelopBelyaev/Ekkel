package com.company.Chapter11;

import java.util.LinkedList;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by oleg on 13.03.16.
 */
public class Stack<T> {
    private LinkedList<T> storage = new LinkedList<T>();

    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        for (String s : "My dog has flea".split(" ")) {
            stringStack.push(s);
        }
        while (!stringStack.empty()) {
            System.out.println(stringStack.pop());
        }
        Random random = new Random(99);
        SortedSet<Integer> sortedSet = new TreeSet<>();
        for (int i = 0; i < 10000; i++) {
            sortedSet.add(random.nextInt(100));
        }
        sortedSet.forEach(System.out::println);
    }

    public void push(T v) {
        storage.addFirst(v);
    }

    public T peek() {
        return storage.getFirst();
    }

    public T pop() {
        return storage.removeFirst();
    }

    public boolean empty() {
        return storage.isEmpty();
    }

    @Override
    public String toString() {
        return storage.toString();
    }
}
