package com.company.sort;

import java.util.Arrays;

//тоже простая сортировка, примерное как bubble,
//но каждую итерацию мы имеем разный промежуток между
//сравниваемыми элементами, каждую итерацию он уменьшается вдвое

//Сортировка Шелла улучшает сортировку вставками
public class ShellSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 23, 454, 2, 8, 234, 7, 12, 5434, 0};
        System.out.println("Original array: " + Arrays.toString(array));

        shellSort(array);

        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    public static void shellSort(int[] array) {
        //получаем шаг как средний эл-т, сначала рассматривается 0й элемент и 0+шаг, потом шаг опять на 2 уменьшается, 5->2->1
        //когда шаг = 1, то реализуется простой алгоритм вставками
        int gap = array.length / 2;
        //пока разница между элементами есть
        while (gap >= 1) {
            for (int right = 0; right < array.length; right++) {
                //смещаем правый указатель, пока не сможем найти такой, что
                //между ним и элементом до него не будет нужного промежутка, проходим по всем парам
                for (int c = right - gap; c >= 0; c -= gap) {
                    if (array[c] > array[c + gap]) {
                        swap(array, c, c + gap);
                    }
                }
            }
            //пересчитываем разрыв
            gap = gap / 2;
        }

    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
