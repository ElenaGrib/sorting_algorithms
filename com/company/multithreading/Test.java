package com.company.multithreading;

public class Test {
    public static void main(String[] args) throws InterruptedException {

        TestClass testClass = new TestClass();

        Thread thread1 = new Thread() {
            public void run() {
                try {
                    testClass.setA(1);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread1.start();

        Thread thread2 = new Thread() {
            public void run() {
                System.out.println("Thread2, reading a: " + testClass.getA());
            }
        };
        thread2.start();

    }
}

class TestClass {
    int a = 5;

    public int getA() {
        return a;
    }

    public void setA(int a) throws InterruptedException {
        this.a = a + 6;

    }


}
