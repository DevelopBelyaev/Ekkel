package com.company.Chapter10.InnerClasses;

/**
 * Created by oleg on 07.03.16.
 */
interface Selector {
    boolean end();

    Object current();

    void next();
}

public class Sequence {
    private Object[] objects;
    private int next = 0;

    public Sequence(final int size) {
        objects = new Object[size];
    }

    public void add(Object x) {
        if (next < objects.length) {
            objects[next++] = x;
        }
    }

    private class SequenceSelector implements Selector {
        private int i = 0;
        @Override
        public boolean end() {
            return (i == objects.length);
        }

        @Override
        public Object current() {
            return objects[i];
        }

        @Override
        public void next() {
            if (i < objects.length) {
                ++i;
            }
        }
    }

    public Selector getSelector() {
        return  new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i));
        }
        Selector selector = sequence.getSelector();
        while (!selector.end()) {
            System.out.println(selector.current());
            selector.next();
        }
    }

}
