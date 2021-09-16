package com.company.streamAPI.otherExamples;

@FunctionalInterface
public interface Fun<T, R> {
    R apply(T t);

    static void doNothingStatic() {
        System.out.println("Do nothing static method");
    }

    default void doNothingByDefault() {
        System.out.println("Do nothing default method");
    }
}