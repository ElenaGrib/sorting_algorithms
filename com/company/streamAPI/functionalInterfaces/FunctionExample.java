package com.company.streamAPI.functionalInterfaces;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionExample {
    //Основной абстрактный метод R apply(T t) принимает объект типа T и возвращает
    //объект типа R. Его задача: выполнить действие над объектом одного
    //типа и возвратить объект другого типа
    public static void main(String[] args) {
        Function<Integer, String> convert = x -> String.valueOf(x) + " string";
        Function<String, Integer> fun1 = s -> s.length();// String to Integer, функция получает строку и преобразует ее в число — длину строки
        Function<Integer, String> fun2 = i -> Integer.toBinaryString(i);//int to String, число преобразует в двоичное представление в виде строки

        System.out.println(convert.apply(5));
        System.out.println(convert.apply(-1));

        String[] arrayStr = {"as", "a", "the", "d", "on", "and", ""};
        System.out.println(Arrays.stream(arrayStr) //преобразуем массив строк в stream
                .map(s -> s.length())  //вызываем метод map, который преобразует поток объектов String в поток чисел (длины строк)
                .collect(Collectors.toList()));

        //default <V> Function<V, R> compose(Function<? super V, ? extends T>before) — возвращает составную функцию, которая сначала применяет ф-ю
        //before к своему входу, а затем применяет эту функцию к результату
        Function<Integer, Integer> fun3 = fun1.compose(fun2);
        //ИЛИ, что тоже самое
        Function<Integer, Integer> fun4 = fun1.compose(i -> Integer.toBinaryString(i));
        System.out.println(fun1.compose(fun2).apply(17)); //снаачала f2 преобразует число в его двоичное представление (10100) в виде строки, потом f1 вычислит длину этой строки


        //default <V> Function<T,V> andThen(Function<? super R, ? extends V> after) — возвращает составную функцию, которая сначала применяет эту
        //функцию к своему входу, а затем применяет функцию after к результату
        //Метод andThen() вызовет функции в порядке, обратном методу compose()
        Function<String, String> fun5 = fun1.andThen(fun2);
        //ИЛИ, что тоже самое
        Function<String, String> fun6 = fun1.andThen(i -> Integer.toBinaryString(i));
        System.out.println(Arrays.stream(arrayStr)
                .map(fun1.andThen(i -> Integer.toBinaryString(i)))
                .collect(Collectors.toList()));



    }

}
