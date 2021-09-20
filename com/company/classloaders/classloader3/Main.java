package com.company.classloaders.classloader3;

import com.company.classloaders.classloader4.CustomClassLoaderDemo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        MyLoader loader = new MyLoader();
        Class<?> c = loader.findClass("com.company.classloaders.classloader3.Hello.class");
        Object ob = c.getDeclaredConstructor().newInstance();
        Method md = c.getMethod("show");
        md.invoke(ob);
    }
}
