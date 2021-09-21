package com.company.multithreading.exceptions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Таким образом можно перехвачивать исключения методо uncaughtException
public class CaptureUncaughtException {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());
    }
}
