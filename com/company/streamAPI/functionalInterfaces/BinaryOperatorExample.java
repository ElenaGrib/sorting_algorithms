package com.company.streamAPI.functionalInterfaces;

import java.util.function.BinaryOperator;

public class BinaryOperatorExample {
    //принимает в качестве аргумента два объекта типа Т
    //выполняет над ними бинарную операцию и возвращает ее результат в виде объекта типа Т
    public static void main(String[] args) {
        BinaryOperator<Integer> mulpitply = (x, y) -> x * y;

        System.out.println(mulpitply.apply(2, 56));
        System.out.println(mulpitply.apply(32, -10));
    }

}
