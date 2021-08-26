package com.company.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 23, 454, 2, 8, 234, 7, 12, 5434, 0};
        System.out.println("Original array:" + Arrays.toString(array));

        selectionSort(array);

        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    public static void selectionSort(int[] array) {
        //рассматриваем подмассивы: 1) берем весь массив, 2) подмассив уже начинается со 1го эл-та, 3) уже со 2го и тд
        for (int i = 0; i < array.length; i++) {
            //в каждом подмассиве находим минимум
            int minIndex = min(array, i, array.length);

            //свопаем найденный минимум с нулевым элементом рассматриваемого подмассива
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    //метод для нахождения минимума в рассматриваемом подмассиве
    //на вход передаем весь подмассив, далее обрезаем его с итого элемента, и рассматриваем его до конца
    //нам нужно получить индекс этого минимального элемента в подмассиве, чтоб потом свопнуть его с нулевым эл-м
    private static int min(int[] subArray, int start, int end) {
        int minIndex = start;
        int minValue = subArray[start];

        //тк нулевой эл-т принимаем за минимальный, то и сравнимаем его с 1м элементом
        for (int i = start + 1; i < end; i++) {
            if (subArray[i] < minValue) {
                minValue = subArray[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
