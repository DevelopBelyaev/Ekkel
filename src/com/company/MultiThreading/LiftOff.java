package com.company.MultiThreading;

/**
 * Created by oleg on 21.03.16.
 */
public class LiftOff implements Runnable {
    protected int countDown = 10; /*default value*/
    private static int taskCount = 0;
    private final int id = taskCount++;
    private static int iteration = 0;
    public LiftOff() {}

    public LiftOff(final int countDown) {
        this.countDown = countDown;
    }

    private String status() {
        ++iteration;
        return System.currentTimeMillis() + "\t#" + id + " (" + (countDown > 0 ? countDown : "lift off )\t" + iteration ) ;
    }
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            Thread.yield();
        }
    }
}
