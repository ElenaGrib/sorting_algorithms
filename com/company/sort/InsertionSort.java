package com.company.sort;

import java.util.Arrays;

//алгоритм сортировки вставками лежит в основе Arrays.sort() (трешхолд для массивов 47)
//сложность O(n^2), но для маленьких массивов гуд
//алгоритм состоит из 2х циклов: 1-для правой неотсортированной последовательности,
//2-для перемещения из левой части элементов вправо если они больше текущего
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 23, 454, 2, 8, 234, 7, 12, 5434, 0};
        System.out.println("Original array:" + Arrays.toString(array));

        insertionSort(array);

        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    private static void insertionSort(int[] array) {
        for (int left = 0; left < array.length; left++) {
            //получаем значение элемента
            int value = array[left];
            //перемещаемся по элементам, которые находятся до выбранного эл-та
            int i = left - 1;
            for (; i >= 0; i--) { //-- т.к. идем в обратном порядке
                //если значение меньшее, то перемещаем больший элемент дальше
                if (value < array[i]) {
                    array[i + 1] = array[i];
                } else {
                    // Если выбранный элемент больше — останавливаемся
                    break;
                }
            }
            // В освободившееся место вставляем выбранный эл-т
            array[i + 1] = value;
        }
    }
}
