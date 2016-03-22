package com.company.MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by oleg on 21.03.16.
 */
public class MainThread {
    static int k = 0;
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 50; i++) {
            executorService.execute(new LiftOff());
        }
    }
}
