package com.company.myCollections;

public interface MyCollections<T> {
    public int size();

    public boolean contains(Object o);

    public void clear();

    public void sort();

    public T get(int index);
}
