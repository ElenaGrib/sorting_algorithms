package com.company.multithreading.exceptions;

public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        System.out.println("caught " + throwable);
    }
}
