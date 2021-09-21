package com.company.multithreading.exceptions;

import java.util.concurrent.ThreadFactory;

public class HandlerThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable runnable) {
        System.out.println(this + " creating new Thread");
        Thread t = new Thread(runnable);
        System.out.println("created " + t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        return t;
    }
}
