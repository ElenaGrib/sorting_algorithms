package com.company.sort;

import java.util.Comparator;

public class QuicksortGeneric {
    public static void quicksort(Object[]  array , int startIndex, int endIndex) {

        if (startIndex < endIndex) {
            //левый подмассив
            int pivotIndex = partition(array, startIndex, endIndex);
            quicksort(array, startIndex, pivotIndex);
            //правый подмассив
            quicksort(array, pivotIndex + 1, endIndex);
        }
    }

    private static int partition(Object[] array , int startIndex, int endIndex) {
        int pivotIndex = (startIndex + endIndex) / 2;
        Object pivotValue = array[pivotIndex];
        startIndex--;
        endIndex++;

        while (true) {
            do startIndex++; while (((Comparable<Object>) array[startIndex]).compareTo(pivotValue) < 0);

            do endIndex--; while (((Comparable<Object>) array[endIndex]).compareTo(pivotValue) > 0);

            if (startIndex >= endIndex) return endIndex;

            Object temp = array[startIndex];
            array[startIndex] = array[endIndex];
            array[endIndex] = temp;
        }
    }
}
