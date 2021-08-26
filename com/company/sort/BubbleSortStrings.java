package com.company.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Задача: Введи с клавиатуры 5 слов и выведи их в алфавитном порядке. Каждое слово - с новой строки.
public class BubbleSortStrings {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = reader.readLine();
        }

        bubbleSort(array);

        for (String word : array) {
            System.out.println(word);
        }
    }

    public static void bubbleSort(String[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (isGreaterThan(array[i], array[j])) {
                    String s = array[i];
                    array[i] = array[j];
                    array[j] = s;
                }
            }
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }
}
