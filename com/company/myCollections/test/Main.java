package com.company.myCollections.test;

import com.company.myCollections.MyArrayList;
import com.company.myCollections.MyHashMap;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("//////////// MyArrayList ////////////");
        MyArrayList<Person> list = new MyArrayList<>();

        Person person1 = new Person(1, "Ivanov", "Ivan", 20);
        Person person2 = new Person(2, "Petrov", "Petr", 25);
        Person person3 = new Person(3, "Stepanov", "Stepan", 30);
        Person person4 = new Person(4, "Ivanov", "Petr", 35);
        Person person5 = new Person(5, "Petrov", "Ivan", 40);

        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        list.add(person5);

        list.print();

        System.out.println("\nSize: " + list.size());

        System.out.println("Contains person3: " + list.contains(person3));

        list.remove(3);

        System.out.println("IndexOf person1: " + list.indexOf(person1));
        System.out.println("Get by index, 2: " + list.get(2));
        System.out.println("Get by index, 10: " + list.get(10));
//        try {
//            System.out.println("Get by index, 100: " + list.get(100));
//        } catch (ArrayIndexOutOfBoundsException ex) {
//            ex.printStackTrace();
//        }

        System.out.println("Contains person4: " + list.contains(person4) + "\n");


        list.sort();

        list.print();

//        System.out.println("\nSubList:");
//        MyArrayList<Person> mySubList = new MyArrayList<>();
//        mySubList.subList(0,3);
//        mySubList.print();

        System.out.println("\n//////////// MyHashMap ////////////");
        MyHashMap<Person, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put(person1, 100);
        myHashMap.put(person2, 200);
        myHashMap.put(person3, 300);
        myHashMap.put(person4, 400);
        myHashMap.put(person5, 500);
        myHashMap.put(person1, 1000);

        MyHashMap.MyEntry myEntry1 = myHashMap.get(person1);
        System.out.println("Key: " + myEntry1.getKey() + " Value: " + myEntry1.getValue());

        myHashMap.remove(person1);
        System.out.println("Key: " + myEntry1.getKey() + " Value: " + myEntry1.getValue());

        System.out.println("Size: " + myHashMap.size());

    }
}
