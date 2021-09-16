package com.company.streamAPI.otherExamples;

import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;
import java.util.stream.LongStream;

public class Example2 {
    public static void main(String[] args) {
        Fun<Double, Double> fun = (x) -> x * 2 + 1;
        double result = fun.apply(3d);
        System.out.println(result);
        fun.doNothingByDefault();
        Fun.doNothingStatic();

        // generator accepts nothing and returns integer value 3
        IntSupplier generator = () -> 3;

        final int factor = 2;

        // multiplier accepts an integer value and returns another one, it uses closure
        IntUnaryOperator multiplier = val -> factor * val;

        // predicate isEven accepts an integer value and returns true if the value is even else false
        IntPredicate isEven = val -> val % 2 == 0;

        // printer accepts a value and prints it in the standard out, it returns nothing
        Consumer<String> printer = System.out::println;

    }

    public static long sumOfOddNumbersInRange(long start, long end) {
        return LongStream.rangeClosed(start, end)
                .filter(x->x%2!=0)
                .reduce(0,(long a, long b)->a+b);
    }

}
