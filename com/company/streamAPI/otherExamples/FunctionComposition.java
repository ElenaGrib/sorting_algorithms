package com.company.streamAPI.otherExamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.awt.SystemColor.text;

public class FunctionComposition {
    public static void main(String[] args) {
        Function<Integer, Integer> adder = x -> x + 10;
        Function<Integer, Integer> multiplier = x -> x * 5;

        // compose: adder(multiplier(5))
        //25+10, тут сначала multiplier, а потом adder
        System.out.println("result: " + adder.compose(multiplier).apply(5));

        // andThen: multiplier(adder(5))
        //15*5, те сначала adder, а потом уже multiplier
        System.out.println("result: " + adder.andThen(multiplier).apply(5));


        //Composing predicates
        IntPredicate isEven = x -> x % 2 == 0;
        IntPredicate dividedBy3 = x -> x % 3 == 0;
        IntPredicate pred = isEven.negate().or(dividedBy3);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(4);
        numbers.add(21);
        // print all odd values and even values that can be divided by 3.
        numbers.forEach(val -> {
            if (pred.test(val)) System.out.print(val + " ");
        });

        IntUnaryOperator mult2 = num -> num * 2;
        IntUnaryOperator add3 = num -> num + 3;

        IntUnaryOperator combinedOperator = add3.compose(mult2.andThen(add3)).andThen(mult2);
        int result = combinedOperator.applyAsInt(5);
        System.out.println(result);

        Consumer<Integer> printer = System.out::println;
        Consumer<Integer> devNull = (val) -> { int v = val * 2; };

        Consumer<Integer> combinedConsumer = devNull.andThen(devNull.andThen(printer));
        combinedConsumer.accept(100);


    }

    public static IntStream createFilteringStream(IntStream evenStream, IntStream oddStream) {
        return IntStream.concat(evenStream,oddStream)
                .filter(x->(x/3==0)&&(x/5==0))
                .sorted()
                .sequential();
    }
}
