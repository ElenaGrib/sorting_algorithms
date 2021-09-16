package com.company.multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExampl {
    public class Solution {
        CountDownLatch latch = new CountDownLatch(1);

        public void someMethod() throws InterruptedException {
            latch.await();
            retrieveValue();
            latch.countDown();
        }

        void retrieveValue() {
            System.out.println("Value retrieved.");
        }

        public static void main(String[] args) throws InterruptedException {
        }
    }
}
