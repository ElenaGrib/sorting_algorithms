package com.company.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] params) {
        int[] array = new int[]{5, 23, 454, 2, 8, 234, 7, 12, 5434, 0};
        System.out.println("Original array:" + Arrays.toString(array));

        array = mergeSort(array);

        System.out.println("Sorted array: " + Arrays.toString(array));
    }


    //метод для сортировки
    public static int[] mergeSort(int[] array) {
        int[] temp; //чтоб менять массивы ниже местами
        int[] currentSrc = array; //массив источник - откуда берем элементы
        int[] currentDest = new int[array.length]; //массив приемник - куда переносим массивы после слияния

        int size = 1; //переменная для хранения текущего размера сливаемого массива (сначала сливаем массивы размером 1, потом 2, потом 4, потом 8 (т.е. *2)
        //сливаем до тех пор, пока размер текущего массива на будет равняться размеру изначального
        //примерно как рекурсия, но тут через while
        while (size < array.length) {
            for (int i = 0; i < array.length; i += 2 * size) {
                merge(currentSrc, i, currentSrc, i + size, currentDest, i, size); //тут мержим массивы с п-ю метода ниже
            }

            //после слияния, меняем местами массив приемник и массив источник, чтоб можно было сливать дальше, на уровень выше
            temp = currentSrc;
            currentSrc = currentDest;
            currentDest = temp;

            size = size * 2; //вот тут умножаем на 2

        }
        return currentSrc;
    }

    //метод для объединения двух отсортированных массивов
    //src1 - исходный первый отсортированный массив, src1Start - элемент, с которого начинаем слияние для первого массива
    //src2 - исходный второй отсортированный массив, src2Start - элемент, с которого начинаем слияние для второго массива
    //int[] dest - промежуточный массив, в который мы сливаем два верхних, destStar - элемент, с которого записываем элементы их двух др массивов
    //size - размер первых двух подмассивов (тех, которые мы будем объединять (слиять)
    private static void merge(int[] src1, int src1Start,
                              int[] src2, int src2Start,
                              int[] dest, int destStart,
                              int size) {

        //эти индексы (указатели) будем сдвигать в каждом из подмассивов по мере переноса элементов в dest массив
        int index1 = src1Start;
        int index2 = src2Start;

        //вычисляем концы подмассивов с учетом их границ
        int src1End = Math.min(src1Start + size, src1.length);
        int src2End = Math.min(src2Start + size, src2.length);

        //вычисляем кол-во итераций, необходимых для объединения (сумма элементов в 2х подмассивах)
        int iterationCount = (src1End - src1Start) + (src2End - src2Start);

        if (src1Start + size > src1.length) {
            for (int i = src1Start; i < src1End; i++) {
                dest[i] = src1[i];
            }
            return;
        }

        for (int i = destStart; i < destStart + iterationCount; i++) {
            if (index1 < src1End && //тут проверяем есть ли ещё элементы в массиве (для случая когда index сдвинулись до конда в одном из массиово, то просто копируем из 2го оставшиеся эл-ты
                    (index2 >= src2End ||
                            //сравнимаем первые элементы двух подмассивов, переносим меньший в dest массив, index этого подмассива сдвигаем на 1
                            src1[index1] < src2[index2])) {
                dest[i] = src1[index1];
                index1++;
            } else {
                dest[i] = src2[index2];
                index2++;
            }
        }
    }
}
