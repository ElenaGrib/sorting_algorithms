package com.company.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 23, 454, 2, 8, 234, 7, 12, 5434, 0};
        System.out.println("Original array:" + Arrays.toString(array));

        quickSort(array, 0, array.length - 1);

        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    //метод принимает сам массив, а также границы подмассива, в рамках которого необходимо выбрать опорный элемент
    //далее рекурсивно будем вызывать этот метод для подмассивов
    public static void quickSort(int[] arr, int from, int to) {
       /*далее проверяем есть ли что вообще сортировать (т.е. индекс начала массива д.б. меньше индекса конца массива
       т.е. если индексы равны, то получается, что в подмассиве остался один элемент, и сортировать уже нечего*/
        if (from < to) {
            //если элемент не один, то переходим уже к выбору опорного элемента, сравнению левых и правых эл-в с опорным, и свопам их
            //нам необходимо тут получить индекс элемента, по которому необходимо разделять массив на подмассивы, т.е. разделитель (divideIndex)
            int divideIndex = division(arr, from, to);

            //рекурсивно сортируем левую часть подмассива c меньшими значениями, т.е. далее первая часть поделится на 2 части и т.д. пока не останется в подмассиве 1 элемент
            quickSort(arr, from, divideIndex - 1);

            //рекурсивно сортируем правую часть подмассива с большими значениями, т.е. далее вторая часть поделится на 2 части и т.д пока не останется в подмассиве 1 элемент
            quickSort(arr, divideIndex, to);
        }
    }

    private static int division(int[] arr, int from, int to) {
        int leftIndex = from;
        int rightIndex = to;

        /*выбираем в качестве опорного средний элемент, можно первый, например,
        но тогда при изначально хорошо отсортированном массиве будет StackOverFlowException*/
        int pivot = arr[from + (to - from) / 2];
        while (leftIndex <= rightIndex) {

            //ищем элемент меньше опорного чтоб перекинуть в левую часть
            while (arr[leftIndex] < pivot) {
                leftIndex++;
            }

            //ищем элемент больше опорного чтоб перекинуть в правую часть
            while (arr[rightIndex] > pivot) {
                rightIndex--;
            }

            //свопаем вышенайденные элементы друг с другом
            if (leftIndex <= rightIndex) {
                swap(arr, rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        //возвращаем разделитель - индекс элемента, по которому необходимо делить
        return leftIndex;
    }

    private static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}
