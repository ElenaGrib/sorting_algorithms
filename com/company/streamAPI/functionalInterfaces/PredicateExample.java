package com.company.streamAPI.functionalInterfaces;

import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample {
    //проверяет соблюдение некоторого условия
    public static void main(String[] args) {
        Predicate<Integer> isPositive = x -> x > 0;

        System.out.println(isPositive.test(5));
        System.out.println(isPositive.test(-10));


        //пример использования логического и
        //Композиции предикатов можно строить, используя методы: default
        //Predicate<T> and(Predicate<? super T> other) — логическое «и»
        String[] arrayStr = {"as", "a", "the", " ", "d", "on", "and", ""};
        Predicate<String> predicate1 = s -> s.contains("a");
        System.out.println(Arrays.stream(arrayStr)
                .filter(predicate1.and(s -> s.contains("n")))
                .collect(Collectors.toList()));
        //ИЛИ, что тоже самое, но без испольщования ссылки на функцию predicate1
        System.out.println(Arrays.stream(arrayStr)
                .filter(((Predicate<String>) s -> s.contains("a")).and(s -> s.contains("n")))
                .collect(Collectors.toList()));


        //default Predicate<T> or(Predicate<? super T> other) — логическое «или»
        int[] arrayInt = {1, 3, 5, 9, 17, 33, 65};
        System.out.println(Arrays.stream(arrayInt)
                .filter(((IntPredicate) i -> i > 32).or(i -> i < 4))
                .boxed()
                .collect(Collectors.toList()));

        //default Predicate<T> negate() — логическое отрицание предиката
        System.out.println(Arrays.stream(arrayStr)
                .filter(((Predicate<String>) s -> s.contains("and")).negate())
                .collect(Collectors.toList()));
        //ИЛИ более короткий вариант
        System.out.println(Arrays.stream(arrayStr)
                .filter(Predicate.not(s -> s.contains("and")))
                .collect(Collectors.toList()));

        //static Predicate<T> isEqual(Object targetRef) — возвращает предикат эк-
        //вивалент метода equals() класса Object. Применяется для поиска точного сов-
        //падения объектов
        //Обычный предикат, эквивалентный приведенному, записывается в виде: s -> s.equals("and")
        System.out.println(Arrays.stream(arrayStr)
                .filter(Predicate.isEqual("and"))
                .collect(Collectors.toList()));


        ////////******////////
        //В пакет java.util.function объявлен еще один интерфейс-предикат BiPredicate<T,U>
        //c абстрактным методом boolean test(T t, U u).
        BiPredicate<String, Integer> biPredicate = (s, max) -> s.length() <= max;
        System.out.println(biPredicate.test("java", 7));


        //Некоторые способы использования предикатов методами интерфейса Stream:
        //filter(Predicate<? super T> predicate);
        //remove(Predicate<? super E> filter);
        //allMatch(Predicate<? super T> predicate);
        //noneMatch(Predicate<? super T> predicate);
        //anyMatch(Predicate<? super T> predicate);
        //takeWhile(Predicate<? super T> predicate);
        //iterate(T seed, Predicate<? super T> hasNext, UnaryOperator<T> next).


    }
}
