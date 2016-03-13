package com.company.Chapter10.InnerClasses.Controller;

/**
 * Created by oleg on 13.03.16.
 */
public abstract class Event {
    private  long eventTime;
    protected final long delayTime;

    Event(final long delayTime) {
        this.delayTime = delayTime;
        start();
    }

    public void start() {
        eventTime = System.nanoTime() + delayTime;
    }

    public boolean ready() {
        return System.nanoTime() >= eventTime;
    }

    public abstract void action();
}

