package com.company.search;

import java.util.Arrays;

public class BinarySearchRecursive {
    public static void main(String[] params) {
        int[] array = new int[]{5, 23, 454, 2, 8, 234, 7, 12, 5434, 0};
        bubbleSort(array);
        System.out.println("Sorted array:" + Arrays.toString(array));
        System.out.println("Index of searching element: " + binarySearchRecursive(array, 0, array.length, 8));
    }

    public static int binarySearchRecursive(int array[], int startIndex, int endIndex, int elementToFind) {
        if (endIndex >= startIndex) {
            int middleIndex = startIndex + (endIndex - startIndex) / 2;

            if (array[middleIndex] == elementToFind) {
                return middleIndex;
            }

            if (array[middleIndex] > elementToFind) {
                return binarySearchRecursive(array, startIndex, middleIndex - 1, elementToFind);
            } else {
                return binarySearchRecursive(array, middleIndex + 1, endIndex, elementToFind);
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
                    int tmp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = tmp;
                    isSorted = false;
                }
            }
        }
    }

}
