package com.company.streamAPI.functionalInterfaces;

import java.util.Arrays;
import java.util.function.Consumer;

public class ConsumerExample {
    //выполняет некоторые действия над объектом типа T, ничего не возвращает
    //Результат действия можно сохранить во внешнем объекте, например,
    //коллекции или вывести в поток вывода, например, в файл или на консоль
    public static void main(String[] args) {
        Consumer<Integer> printer = x -> System.out.printf("%d долларов\n", x);
        printer.accept(400);
        printer.accept(12);

        //consumer преобразует строку на основе разделителя в массив строк
        String str = "as a- the-d -on and";
        String regex = "-";
        Consumer<String> consumer = s -> System.out.println(Arrays.toString(s.split(regex)));
        consumer.accept(str);

        //Вспомогательный метод default Consumer<T> andThen(Consumer<? super T> after)
        // позволяет построить композицию из двух и более действий как одного целого
        //Первый consumer1 удалит из строки все знаки regex1, а второй — все знаки
        //regex2. В итоге будет получено: [, s , - the-d -on , nd]
        String str2 = "as a- the-d -on and";
        String regex1 = "\\s";
        Consumer<String> consumer1 = s -> Arrays.toString(s.split(regex1));
        String regex2 ="a";
        Consumer<String> consumer2 = consumer1
                .andThen(s -> System.out.println(Arrays.toString(s.split(regex2))));
        consumer2.accept(str2);



    }
}
