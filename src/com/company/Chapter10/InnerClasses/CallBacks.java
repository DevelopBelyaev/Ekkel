package com.company.Chapter10.InnerClasses;

/**
 * Created by oleg on 13.03.16.
 */
interface Incremental {
    void increment();
}

class Callee implements Incremental {
    private int i = 0;

    @Override
    public void increment() {
        ++i;
        System.out.println(i);
    }
}

class MyIncrement {
    public static void f(MyIncrement myIncrement) {
        myIncrement.increment();
    }

    public void increment() {
        System.out.println("other operation");
    }
}

class Callee2 extends MyIncrement {
    private int i = 0;

    public void increment() {
        super.increment();
        ++i;
        System.out.println(i);
    }

    Incremental getCallbackReference() {
        return new Closure();
    }

    private class Closure implements Incremental {
        @Override
        public void increment() {
            /**
             * indicates the outer class method
             * otherwise infinite recursion
             */
            Callee2.this.increment();
        }
    }
}

class Caller {
    private Incremental callbackReference;

    Caller(Incremental incremental) {
        callbackReference = incremental;
    }

    void go() {
        callbackReference.increment();
    }
}


public class CallBacks {
    public static void main(String[] args) {
        Callee callee = new Callee();
        Callee2 callee2 = new Callee2();
        Caller caller = new Caller(callee);
        Caller caller1 = new Caller(callee2.getCallbackReference());
        caller.go();
        caller.go();
        caller1.go();
        caller1.go();
    }
}
