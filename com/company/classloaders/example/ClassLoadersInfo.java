package com.company.classloaders.example;

import java.util.ArrayList;

public class ClassLoadersInfo {
    public static void main(String[] args) {
        System.out.println("Classloader of this class: " + ClassLoadersInfo.class.getClassLoader());
        System.out.println("Classloader of ArrayList: " + ArrayList.class.getClassLoader());
    }
}
