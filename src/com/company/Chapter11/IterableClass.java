package com.company.Chapter11;

import java.util.Iterator;

/**
 * Created by oleg on 15.03.16.
 */
public class IterableClass implements Iterable<String> {
    protected String[] words = ("And that is how we know the Earth to be banana-shaped").split(" ");

    public static void main(String[] args) {
        for (String s : new IterableClass()) {
            System.out.print(s + " ");
        }
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<String> iterator() {

        return new Iterator<String>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < words.length;
            }

            @Override
            public String next() {
                return words[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
