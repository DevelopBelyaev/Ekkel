package com.company.Chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by oleg on 13.03.16.
 */

class reversibleArrayList<T> extends ArrayList<T> {
    public reversibleArrayList(Collection<T> ts) {
        super(ts);
    }

    public Iterable<T> reserved() {
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int current = size() - 1;

                    @Override
                    public boolean hasNext() {
                        return current > -1;
                    }

                    @Override
                    public T next() {
                        return get(current--);
                    }

                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }

        };
    }
}

public class AdapterMethodIdiom {
    static void f(String s) {
        System.out.print(s + " ");
    }

    public static void main(String[] args) {
        reversibleArrayList<String> strings = new reversibleArrayList<>(Arrays.asList("to be or not to be".split(" ")));
        strings.forEach(AdapterMethodIdiom::f);
        System.out.println();
        strings.reserved().forEach(AdapterMethodIdiom::f);
    }
}
