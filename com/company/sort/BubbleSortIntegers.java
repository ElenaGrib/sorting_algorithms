package com.company.sort;

import java.util.Arrays;

public class BubbleSortIntegers {
    public static void main(String[] args) {
        int[] array = new int[]{5, 23, 454, 2, 8, 234, 7, 12, 5434, 0};
        System.out.println("Original array: " + Arrays.toString(array));

        bubbleSort(array);

        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    public static void bubbleSort(int[] array) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i - 1] > array[i]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    isSorted = false;
                }
            }
        }
    }
}
