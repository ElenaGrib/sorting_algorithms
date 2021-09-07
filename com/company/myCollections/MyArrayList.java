package com.company.myCollections;

import com.company.sort.QuicksortGeneric;

import java.util.Arrays;

public class MyArrayList<T extends Comparable<? super T>> implements MyCollections {
    private final int DEFAULT_INITIAL_SIZE = 16;
    private final int TRIM_SIZE = 4;
    private Object[] array = new Object[DEFAULT_INITIAL_SIZE];

    private int size = 0;

    //внутренний метод для увеличения размера массива
    private void resize(int newSize) {
        Object[] newArray = new Object[newSize];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    @Override
    public int size() {
        return size;
    }

    public void add(Object element) {

        if (size == array.length - 1)
            resize(array.length * 2); //увеличение размера массива
        array[size++] = element;
    }

    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public boolean contains(Object o) {
        boolean result = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == o) {
                result = true;
                break;
            }
        }
        return result;
    }

    public int indexOf(Object o) {
        int index = -1;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != null && array[i].equals(o)) {
                index = i;
            }
        }
        return index;
    }

    public void remove(int index) {
        for (int i = index; i < size; i++)
            array[i] = array[i + 1]; //сдвигаем элементы влево
        array[size] = null;
        size--;
        if (array.length > DEFAULT_INITIAL_SIZE && size < array.length / TRIM_SIZE)
            resize(array.length / 2); //уменьшаем массив, если элементов в TRIM_SIZE раз меньше чем (по аналогии с методом trim)
    }

    @Override
    public void clear() {
        resize(0);
    }

    public void print() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                System.out.println(array[i]);
            }
        }
    }

    @Override
    public void sort() {
        int newSize = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                newSize++;
            }
        }
        resize(newSize);
        QuicksortGeneric.quicksort(array, 0, array.length-1);
    }

}