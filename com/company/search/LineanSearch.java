package com.company.search;

import java.util.Arrays;

//O(N) - просто проходимся по всем эл-м
public class LineanSearch {
    public static void main(String[] args) {
        int[] array = new int[]{5, 23, 454, 2, 8, 234, 7, 12, 5434, 0};
        bubbleSort(array);
        System.out.println("Sorted array:" + Arrays.toString(array));
        System.out.println("Index of searching element: " + searchLinear(array, 888));
    }

    public static int searchLinear(int[] array, int elementToFind) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == elementToFind) {
                return i;
            }
        }
        return -1;
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
