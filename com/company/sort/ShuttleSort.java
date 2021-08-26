package com.company.sort;

import java.util.Arrays;

//Челночная сортировка, шаттл сорт
//Суть алгоритма в том, что мы итерируемся слева направо,
// при этом при выполнении swap элементов мы выполняем проверку
// всех остальных элементов, которые остались позади, не нужно ли повторить swap.
public class ShuttleSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 23, 454, 2, 8, 234, 7, 12, 5434, 0};
        System.out.println("Original array:" + Arrays.toString(array));

        shuttleSort(array);

        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    private static void shuttleSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                swap(array, i, i - 1);
                for (int z = i - 1; (z - 1) >= 0; z--) {
                    if (array[z] < array[z - 1]) {
                        swap(array, z, z - 1);
                    } else {
                        break;
                    }
                }
            }
        }
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
