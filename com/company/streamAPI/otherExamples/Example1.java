package com.company.streamAPI.otherExamples;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example1 {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.iterate(1, x -> x + 1).limit(100);

        stream.
                skip(20)
                .filter(x -> x % 2 == 0)
                .sorted()
                .forEach((integer -> System.out.print(integer + " ")));


        String[] arrayStr = {"as", "a", "the", " ", "d", "on", "and", ""};
        Stream<String> stringStream = Arrays.stream(arrayStr);

        System.out.println();
        stringStream.sorted().forEach(s -> System.out.print(s + " "));
    }
}
